import java.util.ArrayList;

public class Anonymous {
    private ArrayList<Journal> all;


    public Anonymous (ArrayList<Journal> a) {
        all = a;
    }

    public void printOut () {
        int x = (int) (Math.random() * all.size());
        Journal j = all.get(x);
        System.out.println("Date: " +  j.getDate() + "\n" + "Rate of the day: " + j.getRate() + "\n" + j.getEntry());
    }
}
