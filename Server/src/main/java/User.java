import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    private final String username;
    private final Set<String> friendList = new HashSet<>();
    private final File messageFile;

    public User(String username) {
        this.username = username;
         String messagePath = "E:\\Facultate\\Informatica_2020\\Semestrul_4\\Java\\javaLab10\\Server\\messageFiles\\msg" + username + ".txt";
         messageFile = new File(messagePath);
    }

    public void addFriend(String friend) {
        friendList.add(friend);
    }

    public File getMessageFile() {
        return messageFile;
    }

    public Set<String> getFriendList() {
        return friendList;
    }

    public String getUsername() {
        return username;
    }
}
