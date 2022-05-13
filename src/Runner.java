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
            int line = 1;
            String user = "";
            String password = "";
            Journal j = null;
            // reading from the file line by line
            while (s.hasNextLine()) {
                String data = s.nextLine();
                if (line % 2 != 0) {
                    user = data.substring(data.indexOf(" ") + 1, data.indexOf(","));
                    password = data.substring(data.indexOf(",") + 2);
                }
                if (line % 2 == 0) {
                    String date = data.substring(data.indexOf(" ") + 1, data.indexOf(","));
                    String rate = data.substring(data.indexOf(",") + 1, data.indexOf("|"));
                    String entry = data.substring(data.indexOf("|") + 1);
                    j = new Journal(date, entry, rate);
                }
                line++;
            }
            s.close();
            User u = new User(user, password, j);
            System.out.println("\n"+ "Welcome to Journal Feel! Remember self love is the best love!");
            System.out.println("------------------------------------------------------------" + "\n");
            String option = "";
            while(!(option.equals("3"))) {
                System.out.println("1. Login" + "\n" + "2. Register" + "\n" + "3. Quit");
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
                            Scanner x = new Scanner(System.in);
                            System.out.println("------------------------------------------------------------" + "\n");
                            System.out.print("Today's date: ");
                            String date = x.nextLine();
                            System.out.print("Rate today on a scale of 1-10: ");
                            String rate = x.nextLine();
                            System.out.print("Being your entry: ");
                            String entry = x.nextLine();
                            Journal w = new Journal (date, entry, rate);
                            u.addEntry(w);
                            u.save();
                            break;
                        }

                        else {
                            System.out.println("This password is not correct");
                        }
                    } else {
                        System.out.println("This username does not exist");
                    }
                }
                //if (option.equals("2")) {
                //}
            }


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
            System.out.print("Rate your day on a scale of 1-10: ");
            String rate = in.nextLine();
            System.out.print("Begin your entry: ");
            String entry = in.nextLine();
            Journal j = new Journal (date, entry, rate);
            User u = new User (name, pass, j);
            u.save();
            System.out.print("\n"+"Saving entry... Complete!");
        }
    }












      /*  System.out.println("Welcome to Journaling!");
        Scanner in = new Scanner (System.in);
        System.out.println("1. Login" + "\n" + "2. Register");
        String answer = in.nextLine();

       */




    }
