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
        save();
        System.out.println("\n" + "Saving entry... Complete!" + "\n");
    }

    public void runTime() {
        String option = "";
        while (!(option.equals("2"))) {
            System.out.println("1. Add entry" + "\n" + "2. Quit");
            Scanner in = new Scanner(System.in);
            System.out.print("Enter your option: ");
            option = in.nextLine();
            if (option.equals("1")) {
                addEntry();
            }

        }
    }

    public void save() {
        try {
            boolean t = true;
            File f = new File("src/user.data");
            if (f.createNewFile()) { // this method will create the file if it does not exist, if it does exist, it does nothing
                t = false;
            }
            FileWriter fw = new FileWriter("src/user.data", true);
            if (t) {
                Scanner s = new Scanner(f);
                boolean checkForU = true;
                boolean checkForE = true;
                while (s.hasNextLine()) {
                    String data = s.nextLine();
                    if ((data.contains(userName))) {
                        checkForU = false;
                        System.out.println(checkForU);
                    }
                    for (Journal x : entries) {
                        // need help with reading the file
                        if ((data.contains(x.getDate())) && data.contains(x.getEntry())) {
                                checkForE = false;
                            System.out.println(checkForE);
                        }
                    }
                }

                if (!checkForU && checkForE) {
                    fw.write("USER: " + userName + ", " + password);
                }
                if (checkForU && !checkForE) {
                    for (Journal x : entries) {
                        fw.write("\n" + "ENTRY: ");
                        fw.write(x.getDate() + "|" + x.getEntry() + "; ");
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
}

