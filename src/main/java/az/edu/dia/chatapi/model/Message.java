package az.edu.dia.chatapi.model;

import java.time.LocalDateTime;

public class Message {
    private long ID;
    private long userID;
    private String text;
    private LocalDateTime createdAt;

    public long getID() {
        return ID;
    }
    public void setID(long iD) {
        ID = iD;
    }
    public long getUserID() {
        return userID;
    }
    public void setUserID(long userID) {
        this.userID = userID;
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
