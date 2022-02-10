function chatModule() {
    $(".select2_el").select2({});
    chat();
    // #########
    // 채팅연결
    // #########
    var sockJs = new SockJS("/chat");
    // 1. SockJS를 내부에 들고있는 stomp를 내어줌
    var stomp = Stomp.over(sockJs);
    // 2. connection이 맺어지면 실행
    stomp.connect({}, function () { // 4. subscribe(path, callback)으로 메세지를 받을 수 있음
        stomp.subscribe("/sub/room/" + roomId, function (chat) {
            var content = JSON.parse(chat.body);
            var writer = content.writer;
            var message = content.message;
            var type = content.type;
            var str = '';
            // 상대방 입장 & 퇴장여부
            if (type === 'JOIN' || type === 'LEAVE') {
                str = "<div class='chat-bubble me' style='background-image:linear-gradient( to right, #fff3cd, #fff3cd, #fff3cd, #fff3cd, #fff3cd )'>" + message + "</div>";
                $("#msgArea").append(str);
            }
            // #########
            // 1대1 체팅일때만 사용가능
            // #########
            // 채팅중 체크 
			else if (type === 'WRITING') {
                if (writer != username) {
                    if (!($("#check_bubble").length > 0)) {
                        str = '<div id="check_bubble" class="chat-bubble you"><svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" style=" margin:auto;display:block;shape-rendering:auto;width:43px;height:20px;" viewbox="0 0 100 100" preserveaspectratio="xMidYMid"><circle cx="0" cy="44.1678" r="15" fill="#ffffff"><animate attributename="cy" calcmode="spline" keysplines="0 0.5 0.5 1;0.5 0 1 0.5;0.5 0.5 0.5 0.5" repeatcount="indefinite" values="57.5;42.5;57.5;57.5" keytimes="0;0.3;0.6;1" dur="1s" begin="-0.6s"></animate></circle><circle cx="45" cy="43.0965" r="15" fill="#ffffff"><animate attributename="cy" calcmode="spline" keysplines="0 0.5 0.5 1;0.5 0 1 0.5;0.5 0.5 0.5 0.5" repeatcount="indefinite" values="57.5;42.5;57.5;57.5" keytimes="0;0.3;0.6;1" dur="1s" begin="-0.39999999999999997s"></animate></circle><circle cx="90" cy="52.0442" r="15" fill="#ffffff"><animate attributename="cy" calcmode="spline" keysplines="0 0.5 0.5 1;0.5 0 1 0.5;0.5 0.5 0.5 0.5" repeatcount="indefinite" values="57.5;42.5;57.5;57.5" keytimes="0;0.3;0.6;1" dur="1s" begin="-0.19999999999999998s"></animate></circle></svg></div>';
                    }
                    $("#msgArea").append(str);
                }
            }
            // 상대방이 채팅을 다 지웠거나, 채팅방을 나갔을때 동작 
			else if (type === 'DONE_WRITING') {
                if (writer != username) {
                    if ($("#check_bubble").length > 0) {
                        $('#check_bubble').remove();
                    }
                    $("#msgArea").append(str);
                }
            }
            // #########
            // 1대1 체팅일때만 사용가능 END
            // #########
            // 채팅진행 
			else {
                if (writer === username) {
                    str = "<div class='chat-bubble me'>" + message + "</div>";
                    $("#msgArea").append(str);
                } else {
                    if ($("#check_bubble").length > 0) {
                        $('#check_bubble').remove();
                    }
                    str ="<div class='chat-bubble you'>" + writer + ": " + message + "</div>";
                    $("#msgArea").append(str);
                }
            }
            $(".chat-body").scrollTop($(".chat-body")[0].scrollHeight);
        });
        stomp.send('/pub/enter', {}, JSON.stringify({roomId: roomId, writer: username}));
    });
    function send() {
        var msg = document.getElementById("msg");
        var today = new Date();
        var check = 1;
        console.log(username + ":" + msg.value);
        stomp.send('/pub/message', {}, JSON.stringify({
            roomId: roomId,
            writer: username,
            message: msg.value,
            time: today,
            check: check
        }));
        msg.value = '';
    }
    // 내가 입력중 상대방에게 알림 (...)
    $("#msg").keyup(function (e) { // 채팅을 다 지우면 동작
        if ($(this).val().length == 0) {
            stomp.send('/pub/donWriting', {}, JSON.stringify({roomId: roomId, writer: username}))
            return;
        }
        // input 창안에 focus가 들어올때  event
        stomp.send('/pub/writing', {}, JSON.stringify({roomId: roomId, writer: username}))
        if (e.keyCode == 13) {
            send();
        }
    });
    $('#msg').focusout(function () { // input 창안에 focus가 들어올때  event
        stomp.send('/pub/donWriting', {}, JSON.stringify({roomId: roomId, writer: username}))
        console.log("init out");
    })
    $("#button-send").on("click", function (e) {
        send();
    });
    $(window).on("beforeunload", function () {
        stomp.send('/pub/donWriting', {}, JSON.stringify({roomId: roomId, writer: username}))
        stomp.send('/pub/leave', {}, JSON.stringify({roomId: roomId, writer: username}))
    });
    // #########
    // 기타 설정
    // #########
    // 클릭해야 연결
    $("#initchat").click(function () {
        $(".chat-mail").addClass("hide");
        $(".chat-body").removeClass("hide");
        $(".chat-input").removeClass("hide");
        $(".back-button").removeClass("hide");
    });
    // Toggle fullscreen
    $(".chat-bot-icon").click(function (e) {
        $(this).children("img").toggleClass("hide");
        $(this).children("svg").toggleClass("animate");
        $(".chat-screen").toggleClass("show-chat");
    });
    $(".back-button").click(function () {
        $(".chat-body").addClass("hide");
        $(".chat-input").addClass("hide");
        $(".back-button").addClass("hide");
        $(".chat-mail").removeClass("hide");
    });
    $(".chat-x").click(function (e) {
        $(".chat-bot-icon").children("img").toggleClass("hide");
        $(".chat-bot-icon").children("svg").toggleClass("animate");
        $(".chat-screen").toggleClass("show-chat");
    });
}

function chat() {
    $(".chat-bot-icon").children("img").toggleClass("hide");
    $(".chat-bot-icon").children("svg").toggleClass("animate");
    $(".chat-screen").toggleClass("show-chat");
    $(".chat-mail").addClass("hide");
    $(".chat-body").removeClass("hide");
    $(".chat-input").removeClass("hide");
    $(".back-button").removeClass("hide");
}