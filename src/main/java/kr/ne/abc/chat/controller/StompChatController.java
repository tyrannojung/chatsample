package kr.ne.abc.chat.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import kr.ne.abc.chat.dto.ChatMessageDTO;
import kr.ne.abc.chat.dto.MessageType;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class StompChatController {

    private final SimpMessagingTemplate template; //특정 Broker로 메세지를 전달

    /**
     * enter(입장)
     * @param message
     */
    @MessageMapping(value = "/enter")
    public void enter(ChatMessageDTO message){
    	
        message.setMessage(message.getWriter() + "님이 채팅방에 참여하였습니다.");
        message.setType(MessageType.JOIN);
        template.convertAndSend("/sub/room/" + message.getRoomId(), message);
        
    }
    
    /**
     * leave(퇴장)
     * @param message
     */
    @MessageMapping(value = "/leave")
    public void leave(ChatMessageDTO message){
    	
        message.setMessage(message.getWriter() + "님이 퇴장하셨습니다.");
        message.setType(MessageType.LEAVE);
        template.convertAndSend("/sub/room/" + message.getRoomId(), message);
        
    }

    /**
     * message(메세지보내기)
     * @param message
     */
    @MessageMapping(value = "/message")
    public void message(ChatMessageDTO message){
    	
        template.convertAndSend("/sub/room/" + message.getRoomId(), message);
        
    }
    
    /**
     * writing(채팅 작성중 여부확인)
     * @param message
     */
    @MessageMapping(value = "/writing")
    public void writing(ChatMessageDTO message){
    	
        message.setType(MessageType.WRITING);
        template.convertAndSend("/sub/room/" + message.getRoomId(), message);
        
    }
    
    /**
     * donWriting(채팅 작성x 여부확인)
     * @param message
     */
    @MessageMapping(value = "/donWriting")
    public void donWriting(ChatMessageDTO message){
    	
        message.setType(MessageType.DONE_WRITING);
        template.convertAndSend("/sub/room/" + message.getRoomId(), message);
        
    }
}