package kr.ne.abc.chat.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessageDTO {
	
	/** ChatMessage DTO **/
	private String roomId;
	private MessageType type;
	private String writer;
	private String message;
	
}
