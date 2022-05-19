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
                    if (uI.findUser(userIn)) {
                        System.out.print("Enter Password: ");
                        String pass = in.nextLine();
                        if (pass.equals(uI.getCurrentUser().getPassword())) {
                            System.out.println("\n" + "Welcome back " + u.getUserName() + " Let's start journaling!");
                            System.out.println("------------------------------------------------------------" + "\n");
                            uI.getCurrentUser().addEntry();
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
                    //uu.save();
                    userList.add(uu);
                    entryList.add(jj);
                    System.out.print("\n"+"Saving entry... Complete!"+"\n");
                    break;
                }
            }
              u.runTime(entryList);

        }



    }


    }
