package az.edu.dia.chatapi.model.dto;

import java.time.LocalDateTime;

import az.edu.dia.chatapi.model.User;

public class MessageResponse {
    private String text;
    private LocalDateTime createdAt;
    private User user;
    
    public MessageResponse() {}

    public MessageResponse(String text, LocalDateTime createdAt, User user) {
        this.text = text;
        this.createdAt = createdAt;
        this.user = user;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
}
