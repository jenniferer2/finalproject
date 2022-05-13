public class Journal {
    private String date;
    private String entry;
    private String rate;

    public Journal (String d, String e, String r) {
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

    public String getRate () {
        return rate;
    }




}
