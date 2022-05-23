public class Journal {
    private String date;
    private String entry;
    private String author;


    public Journal (String a ,String d, String e) {
        author = a;
        date = d;
        entry = e;
    }

    public String getAuthor () {
        return author;
    }

    public String getDate () {
        return date;
    }

    public String getEntry () {
        return entry;
    }





}
