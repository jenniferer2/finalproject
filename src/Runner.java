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
                if (line == 1) {
                    user = data.substring(data.indexOf(" ") + 1, data.indexOf(","));
                    password = data.substring(data.indexOf(",") + 1);
                }
                if (line == 2) {
                    String date = data.substring(data.indexOf(" ") + 1, data.indexOf(","));
                    int rate = Integer.parseInt(data.substring(data.indexOf(",") + 1, data.indexOf("|")));
                    String entry = data.substring(data.indexOf("|") + 1);
                    j = new Journal(date, entry, rate);
                }
                line++;
            }
            s.close();
            User u = new User(user, password, j);

            System.out.println("Welcome to Journaling!");
            System.out.println("1. Login" + "\n" + "2. Register");
            Scanner in = new Scanner (System.in);
            System.out.print("Enter your option: ");
            String option = s.nextLine();
            if (option.equals("1")) {
                System.out.print("Enter username: ");
                String userIn = s.nextLine();
                if (userIn.equals(u.getUserName())) {
                    System.out.print("Enter Password: ");
                    String pass = s.nextLine();
                    if (pass.equals(u.getPassword())) {
                        System.out.println("Let's start journaling!");
                    }
                    else {
                        System.out.println("This password is not correct");
                    }
            }
                else {
                    System.out.println("This username does not exist");
                }
        }
            if (option.equals("2")) {

            }
    }












      /*  System.out.println("Welcome to Journaling!");
        Scanner in = new Scanner (System.in);
        System.out.println("1. Login" + "\n" + "2. Register");
        String answer = in.nextLine();

       */




    }


}
