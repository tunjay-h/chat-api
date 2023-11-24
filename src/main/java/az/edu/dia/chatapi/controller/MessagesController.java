package az.edu.dia.chatapi.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import az.edu.dia.chatapi.model.Message;
import az.edu.dia.chatapi.model.dto.MessageResponse;
import az.edu.dia.chatapi.model.dto.NewMessageRequest;
import az.edu.dia.chatapi.service.MessageService;

@CrossOrigin()
@RestController
@RequestMapping(path = "/api/messages")
public class MessagesController {

    private MessageService messageService;

    public MessagesController(MessageService messageService) {
        this.messageService = messageService;
    }

    // get all messages => /api/messages
    // get all messages after certain datetime => /api/messages?after=2020-10-10T12:00:00
    @GetMapping("")
    public List<MessageResponse> getAllMessages(@RequestParam(value = "after", required = false) LocalDateTime afterDateTime) {
        return messageService.getAllMessages(afterDateTime);
    }

    @PostMapping("") 
    public MessageResponse createNewMessage(@RequestBody NewMessageRequest msgBody) {
        return messageService.saveMessage(msgBody);
    }

}
