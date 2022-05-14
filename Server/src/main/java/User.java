import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private List<User> friendList = new ArrayList<>();
    private String messageFile;

    public User(String username) {
        this.username = username;
        messageFile = "./msg" + username + ".txt";
    }

    public void addFriend(User friend) {
        friendList.add(friend);
    }

//    public String getMessages() {
//
//    }
}
