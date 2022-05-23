import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInfo {
    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<Journal> entries = new ArrayList<Journal>();
    private User currentUser;

    public UserInfo() {
        loadUsers();
        currentUser = null;
    }

    public void loadUsers() {
        try {
            File f = new File("src/User.data");
            Scanner s = new Scanner(f);
            String user = "";
            String password = "";
            ArrayList<Journal> jL = new ArrayList<Journal> ();
            while (s.hasNextLine()) {
                String data = s.nextLine();
                if (data.contains("USER:")) {
                    jL = new ArrayList<Journal> ();
                    user = data.substring(data.indexOf(" ") + 1, data.indexOf(","));
                    password = data.substring(data.indexOf(",") + 2);
                    User u = new User (user, password, jL);
                    users.add(u);
                }
            }
            Scanner g = new Scanner(f);
            while (g.hasNextLine()) {
                String data = g.nextLine();
                if (data.contains("ENTRY")) {
                    String author = data.substring(data.indexOf("y") + 2, data.indexOf(":"));
                    String date = data.substring(data.indexOf(":") + 1, data.indexOf("|"));
                    String entry = data.substring(data.indexOf("|") + 1, data.indexOf(";"));
                    Journal jou = new Journal (author, date, entry);
                    entries.add(jou);
                    for (int i = 0; i < users.size(); i++) {
                        if (users.get(i).getUsername().equals(author)) {
                            users.get(i).addEntry(jou);
                        }
                    }
                }
            }
            s.close();
            g.close();

        }
        catch (FileNotFoundException fnf) {
            users = new ArrayList<User>();
        }
    }


    public boolean findUser(String u) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(u)) {
                currentUser = users.get(i);
                return true;
            }
        }
        return false;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void addUser(User u) {
        users.add(u);
    }

    public ArrayList<Journal> getEntries() {
        return entries;
    }

    public String toString () {
        String s = "";
        for (int i = 0; i < users.size(); i ++) {
            s = s + users.get(i).getUsername() + "\n";
            for (int x  = 0; x < users.get(i).getEntries().size(); x++) {
                s = s + users.get(i).getEntries().get(x);

            }
        }
        return s;
    }

    public void save() {
        try {
            File f = new File("src/User.data");
            f.createNewFile();
            FileWriter fw = new FileWriter("src/User.data");
            String data = "";
            for (int i = 0; i < users.size(); i ++) {
                data = users.get(i).getUsername() + ", " + users.get(i).getPassword();
                fw.write("USER: " + data + "\n");
            }
            for (int i = 0; i < users.size(); i ++) {
                for (int x = 0; x < users.get(i).getEntries().size(); x++) {
                    fw.write("ENTRY by " + users.get(i).getUsername() + ":" + users.get(i).getEntries().get(x).getDate() + "|" + users.get(i).getEntries().get(x).getEntry() + ";" + "\n");
                }
            }
            fw.close();

        }
        catch (IOException e) {
            System.out.println("Unable to create file");
            e.printStackTrace();

        }
    }

}


