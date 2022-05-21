import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class User {
    private String userName;
    private String password;
    private ArrayList<Journal> entries = new ArrayList<Journal>();


    public User(String u, String p, Journal j) {

        userName = u;
        password = p;
        entries.add(j);
    }

    public User (String u, String p, ArrayList<Journal> e) {
        userName = u;
        password = p;
        entries = e;
    }

    public User () {
        read();
    }

    public User (String u, String pass) {
        userName = u;
        password = pass;
        entries = null;

    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Journal> getEntries() {
        return entries;
    }

    public void addEntry(Journal w) {
      entries.add(w);
    }
    public void removeExtra () {
            for (int i = 0; i < entries.size(); i++) {
                String x = entries.get(i).getDate() + "|" + entries.get(i).getEntry();
                for (int xx = i + 1; xx < entries.size(); xx++) {
                    String w = entries.get(xx).getDate() + "|" + entries.get(xx).getEntry();
                    if (x.equals(w)) {
                        entries.remove(entries.get(xx));
                    }
                }
            }
        }


    public boolean addUser (String name, ArrayList<User> u) {

        boolean check = true;
        for (User uu : u) {
            if (uu.getUserName().equals(name)) {
                check = false;
            }
        }
        return check;

    }

    public String toString () {
        String s = "";
        String one = userName + " |" + password;
        for (int i = 0; i < entries.size(); i++) {
            String g = entries.get(i).getDate() + "|" +entries.get(i).getEntry();
            s = "\n" + s + g;
        }
        return one + s ;
    }
    public void read() {
        try {
            String name = getUserName();
            File f = new File("src/" + userName + ".data");
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
                if (data.contains("ENTRY:")) {
                    String date = data.substring(data.indexOf(" ") + 1, data.indexOf("|"));
                    String entry = data.substring(data.indexOf("|") + 1, data.indexOf(";"));
                    j = new Journal(date, entry);
                    jL.add(j);
                }
            }
            User uu = new User(user, password, jL);
            s.close();

        } catch (FileNotFoundException fnf) {
            System.out.println("File not found");
        }
    }

    public void save() {
        try {
            File f = new File("src/" + userName + ".data");
            f.createNewFile();
            FileWriter fw = new FileWriter("src/" + userName + ".data");
            String data = "";
            data = userName + ", " + password;
            fw.write("USER: " + data + "\n");
            for (int i = 0; i < getEntries().size(); i++) {
                fw.write("ENTRY: " + getEntries().get(i).getDate() + "|" + getEntries().get(i).getEntry() + ";" + "\n");
            }

            fw.close();

        } catch (IOException e) {
            System.out.println("Unable to create file");
            e.printStackTrace();

        }
    }

}

