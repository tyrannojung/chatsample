package kr.ne.abc.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.ne.abc.chat.service.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequiredArgsConstructor
@Log4j2
public class RoomController {

    private final ChatRoomRepository repository;

    /**
     * rooms (채팅방 목록 조회)
     * @return
     */
    @GetMapping(value = "/rooms")
    public ModelAndView rooms(){

        log.info("# All Chat Rooms");
        ModelAndView mv = new ModelAndView("/rooms");
        mv.addObject("list", repository.findAllRooms());
        
        return mv;
        
    }

    /**
     * create(채팅방 개설)
     * @param name
     * @param rttr
     * @return
     */
    @PostMapping(value = "/room")
    public String create(@RequestParam String name, RedirectAttributes rttr){

        log.info("# Create Chat Room , name: " + name);
        rttr.addFlashAttribute("roomName", repository.createChatRoomDTO(name));
        
        return "redirect:/rooms";
        
    }

    /**
     * getRoom (채팅방 입장)
     * @param roomId
     * @return
     */
    @GetMapping("/room/{roomId}")
    public ModelAndView getRoom(@PathVariable("roomId") String roomId){
    	
        log.info("# get Chat Room, roomID : " + roomId);
        ModelAndView mv = new ModelAndView("/room");
        mv.addObject("room", repository.findRoomById(roomId));
        
        return mv;
        
    }
}