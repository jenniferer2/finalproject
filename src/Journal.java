public class Journal {
    private String date;
    private String entry;
    private int rate;

    public Journal (String d, String e, int r) {
        date = d;
        entry = e;
        rate = r;
    }

    public String getDate () {
        return date;
    }

    public String getEntry () {
        return entry;
    }

    public int getRate () {
        return rate;
    }




}
