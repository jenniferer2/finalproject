import java.util.ArrayList;

public class User {
    private String userName;
    private String password;
    private ArrayList<Journal> entries;


    public User (String u, String p, Journal j) {
        userName = u;
        password = p;
        entries.add(j);
    }

    public String getUserName () {
        return userName;
    }

    public String getPassword () {
        return password;
    }

    
}
