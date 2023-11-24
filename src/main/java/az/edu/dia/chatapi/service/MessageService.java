package az.edu.dia.chatapi.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import az.edu.dia.chatapi.model.Message;
import az.edu.dia.chatapi.model.User;
import az.edu.dia.chatapi.model.dto.MessageResponse;
import az.edu.dia.chatapi.model.dto.NewMessageRequest;
import az.edu.dia.chatapi.repo.MessageRepo;
import az.edu.dia.chatapi.repo.UserRepo;

@Service
public class MessageService {

    private MessageRepo messageRepo;
    private UserRepo userRepo;

    public MessageService(MessageRepo messageRepo, UserRepo userRepo) {
        this.messageRepo = messageRepo;
        this.userRepo = userRepo;
    }

    public List<MessageResponse> getAllMessages(LocalDateTime after) {
        List<Message> allMessages = messageRepo.getAllMessages();
        List<User> allUsers = userRepo.getAllUsers();

        var result = new ArrayList<MessageResponse>();

        for (Message message : allMessages) {

            for (User user : allUsers) {
                
                if (user.getID() == message.getUserID()) {

                    var msgResponse = new MessageResponse(message.getText(), message.getCreatedAt(), user);

                    if (after != null && message.getCreatedAt().isAfter(after)) {
                        result.add(msgResponse);
                    } else {
                        result.add(msgResponse);
                    }     
                }
            }
        }

        return result;
    }

    public MessageResponse saveMessage(NewMessageRequest msgRequest) {
        List<User> allUsers = userRepo.getAllUsers();
        Message msg = new Message();
        msg.setText(msgRequest.getText());
        msg.setCreatedAt(LocalDateTime.now());

        for (User user : allUsers) {
            if (user.getUsername().equals(msgRequest.getUsername())) {
                msg.setUserID(user.getID());
            }
        }

        // save and update with id
        msg = messageRepo.createMessage(msg);

        MessageResponse msgResponse = new MessageResponse();
        msgResponse.setCreatedAt(msg.getCreatedAt());
        return msgResponse;
    }
}
