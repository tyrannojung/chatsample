<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=yes"/>
<title>Chat Bot UI/UX & html for web Plugin | Css3 Transition</title>
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="https://fonts.googleapis.com/css?family=Nunito:400,600,700" rel="stylesheet"/>
<link href="/common/chat/css/main.css" rel="stylesheet" type="text/css"/>
<!-- END GLOBAL MANDATORY STYLES -->
<link href="/common/chat/css/select2.min.css" rel="stylesheet" type="text/css"/>
<link href="/common/chat/css/chatBot.css" rel="stylesheet" type="text/css"/>
<link href="/common/chat/css/timeline.css" rel="stylesheet" type="text/css"/>
<!-- Time line Html Ends -->
<script src="/common/chat/js/select2.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
<script src="https://ajax.cloudflare.com/cdn-cgi/scripts/7089c43e/cloudflare-static/rocket-loader.min.js" data-cf-settings="257be86a981729866f2fa61c-|49" defer=""></script>
<script src="/common/js/chat.js"></script>
<script>
var roomId = '${room.roomId}';
var username = "<sec:authentication property="principal.username"/>";
$(function() {
    chatModule();
});
</script>
</head>
<body>
    <!-- Chat bot UI start -->
    <div class="chat-screen">
        <div class="chat-header">
            <div class="chat-header-title">
                <svg class="back-button hide" xmlns="http://www.w3.org/2000/svg" viewbox="0 0 512 512" width="24" height="24">
                    <path fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="48" d="M244 400L100 256l144-144M120 256h292"></path>
                </svg>
                ${room.name}
            </div>
            <div class="chat-header-option">
                <span class="dropdown custom-dropdown chat-x">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewbox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-x">
                        <line x1="18" y1="6" x2="6" y2="18"></line>
                        <line x1="6" y1="6" x2="18" y2="18"></line>
                    </svg>
                </span>
            </div>
        </div>
        <div class="chat-mail">
            <div class="row">
                <div class="col-md-12">
                    <div class="messages-box">
                        <div
                            class="list-group rounded-0">
                            <!-- 채팅방 -->
                            <div id="initchat" class="list-group-item list-group-item-action rounded-0" style="cursor:pointer;">
                                <div class="media">
                                    <div class="media-left" style="position:relative">
                                        <img class="media-object rounded-circle" src="/common/chat/img/sample_img (12).jpg" style="width: 48px; height: 48px;"/>
                                        <div style="width: 7px; height: 7px; border-radius: 50%; background-color: #4FC32F; position: absolute; right:0; bottom:0;"></div>
                                    </div>
                                    <div class="media-body ml-4">
                                        <div class="d-flex align-items-center justify-content-between mb-1">
                                            <h6 class="mb-0">0x02a...addBb</h6>
                                            <small class="small font-weight-bold">25 Dec</small>
                                        </div>
                                        <p class="font-italic mb-0 text-small">
                                            준비중 클릭
                                        </p>
                                    </div>
                                </div>
                            </div>
                            <!--  -->
                        </div>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="powered-by">
                        Powered by ABC
                    </div>
                </div>
            </div>
        </div>
        <div class="chat-body hide">
            <div class="chat-box" id="msgArea">
                <div class="chat-start">
                    Monday, 1:27 PM
                </div>
            </div>
        </div>
        <div class="chat-input hide">
            <input id="msg" type="text" placeholder="Type a message..." autocomplete="off"/>
            <div class="input-action-icon" id="button-send">
                <a>
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewbox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-send">
                        <line x1="22" y1="2" x2="11" y2="13"></line>
                        <polygon points="22 2 15 22 11 13 2 9 22 2"></polygon>
                    </svg>
                </a>
            </div>
        </div>
    </div>
    <div class="chat-bot-icon">
        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewbox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-message-square animate">
            <path d="M21 15a2 2 0 0 1-2 2H7l-4 4V5a2 2 0 0 1 2-2h14a2 2 0 0 1 2 2z"></path>
        </svg>
        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewbox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-x">
            <line x1="18" y1="6" x2="6" y2="18"></line>
            <line x1="6" y1="6" x2="18" y2="18"></line>
        </svg>
    </div>
</body>
</html>
    