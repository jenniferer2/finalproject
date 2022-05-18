import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Runner {
    static ArrayList<User> saveUserList = new ArrayList<User> ();

    public static void main (String args[]) {
        try {
            File f = new File("src/User.data");
            Scanner s = new Scanner(f);
            String user = "";
            String password = "";
            Journal j = null;
            ArrayList<User> userList = new ArrayList<User> ();
            ArrayList<Journal> entryList = new ArrayList<Journal> ();
            ArrayList<String> userNList = new ArrayList<String> ();
            // reading from the file line by line
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
                    entryList.add(j);
                }

            }
            s.close();
            User u = new User(user, password, j);
            userList.add(u);
            boolean see = true;
            System.out.println("\n"+ "Welcome to the Diary! Remember self love is the best love!");
            System.out.println("------------------------------------------------------------" + "\n");
            String option = "";
            while(!(option.equals("3"))) {
                System.out.println("1. Login" +"\n" + "2. Register" + "\n" + "3. Quit");
                Scanner in = new Scanner(System.in);
                System.out.print("Enter your option: ");
                 option = in.nextLine();
                if (option.equals("1")) {
                    see = false;
                    boolean check = false;
                    System.out.print("Enter username: ");
                    String userIn = in.nextLine();
                    int findIndex = 0;
                    for (int i = 0; i < userList.size(); i ++) {
                        if (userList.get(i).getUserName().equals(userIn)) {
                            check = true;
                            findIndex = i;
                            break;
                        }
                    }
                    if (check) {
                        System.out.print("Enter Password: ");
                        String pass = in.nextLine();
                        if (pass.equals(userList.get(findIndex).getPassword())) {
                            System.out.println("\n" + "Welcome back " + u.getUserName() + " Let's start journaling!");
                            System.out.println("------------------------------------------------------------" + "\n");
                            u.addEntry();
                            break;
                        }
                        else {
                            System.out.println("This password is not correct");
                        }
                    } else {
                        System.out.println("This username does not exist");
                    }
                }
                if (option.equals("2")) {
                    for (User uu : userList) {
                        userNList.add(uu.getUserName());
                    }
                    System.out.println("Registration");
                    Scanner x = new Scanner(System.in);
                    System.out.print("Set a username: ");
                    String name = x.nextLine();
                    while (userNList.contains(name)) {
                        System.out.println("This username is already taken:");
                        System.out.print("Set a username: ");
                        name = x.nextLine();
                    }
                    System.out.print("Set a password: ");
                    String pass = x.nextLine();
                    System.out.print("\n"+ "All set! Journaling time!" + "\n" + "Today's date: ");
                    String date = x.nextLine();
                    System.out.print("Begin your entry: ");
                    String entry = x.nextLine();
                    Journal jj = new Journal (date, entry);
                    User uu = new User (name, pass, jj);
                    uu.save();
                    userList.add(uu);
                    entryList.add(jj);
                    System.out.print("\n"+"Saving entry... Complete!"+"\n");
                    break;
                }
            }
            saveUserList = userList ;

              u.runTime(entryList);

        } catch (FileNotFoundException e) {
            System.out.println("\n"+ "Welcome to Journal Feel! Remember self love is the best love!");
            System.out.println("------------------------------------------------------------" + "\n");
            System.out.println("Registration");
            Scanner in = new Scanner(System.in);
            System.out.print("Set a username: ");
            String name = in.nextLine();
            System.out.print("Set a password: ");
            String pass = in.nextLine();
            System.out.print("\n"+ "All set! Journaling time!" + "\n" + "Today's date: ");
            String date = in.nextLine();
            System.out.print("Begin your entry: ");
            String entry = in.nextLine();
            Journal j = new Journal (date, entry);
            User u = new User (name, pass, j);
            u.save();
            System.out.print("\n"+"Saving entry... Complete!"+"\n");
            System.out.print("Congrats you have made your first post!");


        }

    }

    public void save() {
        for (User u : saveUserList) {
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

                        for (int i = 0; i < u.getEntries().size(); i ++) {
                            if (data.contains(u.getEntries().get(i).getEntry()))
                            {
                                track.add(i);
                            }

                        }
                    }

                    for (int i = 0; i < u.getEntries().size(); i++) {
                        if (!(track.contains(i))) {
                            fw.write("\n" + "ENTRY: ");
                            fw.write(u.getEntries().get(i).getDate() + "|" + u.getEntries().get(i).getEntry() + "; ");
                        }

                    }
                }
                else {
                    fw.write("USER: " + u.getUserName() + ", " + u.getPassword());
                    for (Journal x : u.getEntries()) {
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


    }
