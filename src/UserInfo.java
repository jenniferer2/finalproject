import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInfo {
    private ArrayList<User> users;
    private User currentUser;

    public UserInfo() {
        loadUsers();
        currentUser = null;
    }

    public void loadUsers() {
        try {
            users = new ArrayList<User>();
            File f = new File("src/user.data");
            Scanner s = new Scanner(f);
            String user = "";
            String password = "";
            ArrayList<Journal> jList = new ArrayList<Journal> ();
            while (s.hasNextLine()) {
                String data = s.nextLine();
                if (data.contains("USER:")) {
                    user = data.substring(data.indexOf(" ") + 1, data.indexOf(","));
                    password = data.substring(data.indexOf(",") + 2);
                }
                if (data.contains("ENTRY:")) {
                    jList = new ArrayList<Journal> ();
                    while (!(s.nextLine().contains("ENTRY:"))) {
                        String date = data.substring(data.indexOf(" ") + 1, data.indexOf("|"));
                        String entry = data.substring(data.indexOf("|") + 1, data.indexOf(";"));
                        Journal j = new Journal(date, entry);
                        jList.add(j);
                    }
                }
                User u = new User(user, password, jList);
                users.add(u);
            }
            s.close();
        }
        catch (FileNotFoundException fnf) {
            users = new ArrayList<User>();
        }
    }

    public boolean findUser (String u) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserName().equals(u)) {
                currentUser = users.get(i);
                return true;
            }
        }
        return false;
    }

    public User getCurrentUser () {
        return currentUser;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void addUser (User u) {
        users.add(u);
    }
}
