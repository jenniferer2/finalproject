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

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Journal> getEntries() {
        return entries;
    }

    public void addEntry() {
        Scanner x = new Scanner(System.in);
        System.out.print("Today's date: ");
        String date = x.nextLine();
        System.out.print("Begin your entry: ");
        String entry = x.nextLine();
        Journal w = new Journal(date, entry);
        entries.add(w);
        //save();
        System.out.println("\n" + "Saving entry... Complete!" + "\n");
    }

    public void runTime(ArrayList<Journal> j) {
        String option = "";
        while (!(option.equals("3"))) {
            System.out.println("1. Add entry" + "\n" + "2. Read an anonymous entry" + "\n" + "3. Quit");
            Scanner in = new Scanner(System.in);
            System.out.print("Enter your option: ");
            option = in.nextLine();
            if (option.equals("1")) {
                addEntry();
            }
            if (option.equals("2")) {
                Journal ran = anon(j);
                System.out.println("\n"+"Anonymous entry:");
                System.out.println(ran.getDate() + "\n" + ran.getEntry()+"\n");
            }

        }
    }

    public Journal anon (ArrayList<Journal> j) {
        int length = j.size();
        int num = (int) (Math.random () * length ) ;
        return j.get(num);
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

    /*public void save() {
        try {
            boolean t = true;
            File f = new File("src/user.data");
            if (f.createNewFile()) { // this method will create the file if it does not exist, if it does exist, it does nothing
                t = false;
            }
            FileWriter fw = new FileWriter("src/user.data", true);
            if (t) {
                Scanner s = new Scanner(f);

                ArrayList<Integer> track = new ArrayList<Integer> ();
                while (s.hasNextLine()) {
                    String data = s.nextLine();

                    for (int i = 0; i < entries.size(); i ++) {
                        if (data.contains(entries.get(i).getEntry()))
                        {
                            track.add(i);
                        }

                    }
                }

                    for (int i = 0; i < entries.size(); i++) {
                        if (!(track.contains(i))) {
                            fw.write("\n" + "ENTRY: ");
                            fw.write(entries.get(i).getDate() + "|" + entries.get(i).getEntry() + "; ");
                        }

                    }
            }
            else {
                fw.write("USER: " + userName + ", " + password);
                for (Journal x : entries) {
                    fw.write("\n" + "ENTRY: ");
                    fw.write(x.getDate() + "|" + x.getEntry() + "; ");
                }


            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Unable to create file");
            e.printStackTrace();
        }


    }

     */


}

