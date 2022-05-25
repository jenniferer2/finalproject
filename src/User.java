import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class User {

    private String username;
    private String password;
    private ArrayList<Journal> entries = new ArrayList<Journal>();


    public User (String u, String p, ArrayList<Journal> e) {
        username = u;
        password = p;
        entries = e;
    }


    public String getUsername() {
        return username;
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

    public String toString () {
        String end = "";
        String userAndPass = username + " |" + password;
        for (int i = 0; i < entries.size(); i++) {
            String entrys = entries.get(i).getDate() + "|" +entries.get(i).getEntry();
            end = "\n" + end + entrys;
        }
        return userAndPass + end ;
    }

    public void runtime (ArrayList<Journal> jL) {
        String o = "";
        while (!(o.equals("3"))) {
            System.out.println("1. Add entry" + "\n" + "2. Read an anonymous entry" + "\n" + "3. Quit" + "\n");
            Scanner w = new Scanner(System.in);
            System.out.print("Enter your option: ");
            o = w.nextLine();
            if (o.equals("1")) {
                System.out.println("------------------------------------------------------------");
                Scanner x = new Scanner(System.in);
                System.out.print("Today's date: ");
                String date = x.nextLine();
                System.out.print("Begin your entry: ");
                String entry = x.nextLine();
                Journal ww = new Journal(username, date, entry);
                addEntry(ww);
                System.out.print("\n" + "Saving entry... Complete!" + "\n");
                System.out.println("------------------------------------------------------------");

            }
            if (o.equals("2")) {
                System.out.println("------------------------------------------------------------");
                System.out.println("Anonymous Entry: ");
                int length = jL.size();
                int ran = (int) (Math.random() * length - 1 ) ;
                Journal j = jL.get(ran);
                System.out.println("Date: " + j.getDate() + "\n" + "Entry: " + j.getEntry());
                System.out.println("------------------------------------------------------------");

            }
            }
    }

}

