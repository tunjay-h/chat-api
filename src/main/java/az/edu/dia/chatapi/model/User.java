package az.edu.dia.chatapi.model;

// plain old java object - POJO
public class User {
    
    private String username;
    private String profileAvatarUrl;

    public User(String username, String profileAvatarUrl) {
        this.username = username;
        this.profileAvatarUrl = profileAvatarUrl;
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
