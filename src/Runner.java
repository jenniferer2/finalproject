import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Runner {

    public static void main (String args[]) {
        UserInfo uI = new UserInfo ();
        User thisUser = new User ();
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
                    System.out.print("Enter username: ");
                    String userIn = in.nextLine();
                    if (uI.findUser(userIn)) {
                        System.out.print("Enter Password: ");
                        String pass = in.nextLine();
                        if (pass.equals(uI.getCurrentUser().getPassword())) {
                            thisUser = uI.getCurrentUser();
                            System.out.println("\n" + "Welcome back " + thisUser.getUserName() + " Let's start journaling!");
                            System.out.println("------------------------------------------------------------" + "\n");
                            break;
                           /* Scanner x = new Scanner(System.in);
                            System.out.print("Today's date: ");
                            String date = x.nextLine();
                            System.out.print("Begin your entry: ");
                            String entry = x.nextLine();
                            Journal w = new Journal(date, entry);
                            uI.addEntry(thisUser.getUserName(), w);
                            System.out.println("\n" + "Saving entry... Complete!" + "\n");
                            break;

                            */
                        }
                        else {
                            System.out.println("This password is not correct");
                        }
                    } else {
                        System.out.println("This username does not exist");
                    }
                }
                if (option.equals("2")) {
                    System.out.println("Registration");
                    Scanner x = new Scanner(System.in);
                    System.out.print("Set a username: ");
                    String name = x.nextLine();
                    while (uI.findUser(name)) {
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
                    thisUser = uu;
                    uI.addUser(uu);
                    thisUser.addEntry(jj);
                    System.out.print("\n"+"Saving entry... Complete!"+"\n");
                    break;

                }
            }
        /*String o = "";
        while (!(o.equals("3"))) {
            System.out.println("1. Add entry" + "\n" + "2. Read an anonymous entry" + "\n" + "3. Quit");
            Scanner w = new Scanner(System.in);
            System.out.print("Enter your option: ");
            o = w.nextLine();
            if (o.equals("1")) {
                Scanner x = new Scanner(System.in);
                System.out.print("Today's date: ");
                String date = x.nextLine();
                System.out.print("Begin your entry: ");
                String entry = x.nextLine();
                Journal ww = new Journal(date, entry);
                //uI.addEntry(thisUser.getUserName(), ww);
                thisUser.addEntry(ww);

                System.out.println("\n" + "Saving entry... Complete!" + "\n");
            }

            }
            /*if (option.equals("2")) {
                Journal ran = thisUser.anon(thisU);
                System.out.println("\n"+"Anonymous entry:");
                System.out.println(ran.getDate() + "\n" + ran.getEntry()+"\n");
            }

             */
            thisUser.removeExtra();
            thisUser.save();

           uI.save();

            //uI.print();


        }



    }
