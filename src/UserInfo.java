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
            File f = new File("src/User.data");
            Scanner s = new Scanner(f);
            String user = "";
            String password = "";
            Journal j = null;
            ArrayList<Journal> jL = new ArrayList<Journal> ();
            while (s.hasNextLine()) {
                String data = s.nextLine();
                if (data.contains("USER:")) {
                    user = data.substring(data.indexOf(" ") + 1, data.indexOf(","));
                    password = data.substring(data.indexOf(",") + 2);

                }
            }
            User u = new User(user, password);
            users.add(u);
            s.close();

        } catch (FileNotFoundException fnf) {
            users = new ArrayList<User>();
        }
    }


    public boolean findUser(String u) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserName().equals(u)) {
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

    public void print () {
        for (int i = 0; i < users.size(); i ++) {
            System.out.println(users.get(i).getUserName());
        }
    }

    public void save() {
        try {

            File f = new File("src/User.data");
            f.createNewFile();
            FileWriter fw = new FileWriter("src/User.data");
            String data = "";
            for (int i = 0; i < users.size(); i ++) {
                data = users.get(i).getUserName() + ", " + users.get(i).getPassword();
                fw.write("USER: " + data + "\n");
            }
                /*data = u.getUserName() + ", " + u.getPassword();
                fw.write("USER: " + data + "\n");
                for (int i = 0; i < u.getEntries().size(); i++) {
                    fw.write("ENTRY: " + u.getEntries().get(i).getDate() + "|" + u.getEntries().get(i).getEntry() + ";" + "\n");
                    }

                 */

            fw.close();

        } catch (IOException e) {
            System.out.println("Unable to create file");
            e.printStackTrace();

        }
    }


    /*public void print () {
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i).toString());
        }
    }

     */

    /*public void addEntry (String uN, Journal j) {
        for (User u : users) {
            if (u.getUserName().equals(uN)) {
                u.addEntry(j);
            }
        }

     */
    }


