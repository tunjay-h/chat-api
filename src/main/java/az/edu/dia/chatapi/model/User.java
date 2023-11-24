package az.edu.dia.chatapi.model;

// plain old java object - POJO
public class User {
    
    private long ID;
    private String username;
    private String profileAvatarUrl;

    public User(String username, String profileAvatarUrl) {
        this.username = username;
        this.profileAvatarUrl = profileAvatarUrl;
    }

    public long getID() {
        return ID;
    }

    public void setID(long iD) {
        ID = iD;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfileAvatarUrl() {
        return profileAvatarUrl;
    }

    public void setProfileAvatarUrl(String profileAvatarUrl) {
        this.profileAvatarUrl = profileAvatarUrl;
    }

}
