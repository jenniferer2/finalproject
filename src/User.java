import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

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

    public ArrayList<Journal> getEntries () {
        return entries;
    }

    public void setUser (String x) {
        userName = x;
    }

    public void setPassword (String y) {
        password = y;
    }

    public void save () {
        try {
            File f = new File("src/user.data");
            f.createNewFile(); // this method will create the file if it does not exist, if it does exist, it does nothing
            FileWriter fw = new FileWriter("src/user.data");
            fw.write("USER: " + userName + ", " + password);
            for (Journal x : entries) {
            fw.write ("ENTRY: " + x.getDate() + ", " + x.getRate() + " |" + x.getEntry());
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Unable to create file");
            e.printStackTrace();
        }
    }

    }

