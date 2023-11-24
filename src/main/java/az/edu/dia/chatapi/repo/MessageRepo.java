package az.edu.dia.chatapi.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import az.edu.dia.chatapi.model.Message;

@Repository
public class MessageRepo {
    private static final List<Message> allMessages = new ArrayList<>();
    private static long generatedID = 1; // increment on new msg

    public List<Message> getAllMessages() {
        return allMessages;
    }

    public Message createMessage(Message msg) {
        generatedID += 1;
        msg.setID(generatedID);
        allMessages.add(msg);
        return msg;
    }
}
