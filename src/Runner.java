import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Runner {

    public static void main (String args[]) {
        try {
            File f = new File("src/User.data");
            Scanner s = new Scanner(f);
            String user = "";
            String password = "";
            Journal j = null;
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
                }

            }
            s.close();
            User u = new User(user, password, j);
            System.out.println("\n"+ "Welcome to the Diary! Remember self love is the best love!");
            System.out.println("------------------------------------------------------------" + "\n");
            String option = "";
            while(!(option.equals("2"))) {
                System.out.println("1. Login" +"\n" + "2. Quit" + "\n");
                Scanner in = new Scanner(System.in);
                System.out.print("Enter your option: ");
                 option = in.nextLine();
                if (option.equals("1")) {
                    System.out.print("Enter username: ");
                    String userIn = in.nextLine();
                    if (userIn.equals(u.getUserName())) {
                        System.out.print("Enter Password: ");
                        String pass = in.nextLine();
                        if (pass.equals(u.getPassword())) {
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
            }
             u.runTime();

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
            u.runTime();

        }
    }















    }
