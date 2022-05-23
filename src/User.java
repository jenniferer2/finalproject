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


    public User (String u, String p, ArrayList<Journal> e) {
        userName = u;
        password = p;
        entries = e;
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

    public void runtime () {
        String o = "";
        while (!(o.equals("2"))) {
            System.out.println("1. Add entry" + "\n" + "2. Quit");
            Scanner w = new Scanner(System.in);
            System.out.print("Enter your option: ");
            o = w.nextLine();
            if (o.equals("1")) {
                Scanner x = new Scanner(System.in);
                System.out.print("Today's date: ");
                String date = x.nextLine();
                System.out.print("Begin your entry: ");
                String entry = x.nextLine();
                Journal ww = new Journal(userName, date, entry);
                addEntry(ww);
                System.out.println("\n" + "Saving entry... Complete!" + "\n");
            }

            }

    }

}

