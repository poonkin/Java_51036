package P8_11;

/**
 * Created by dsvid88 on 4/16/15.
 */

public class Letter {

    private String from;
    private String to;
    private String body;

    public Letter(String from, String to) {
        this.to = "Dear " + to + ": \n" + "\n";
        this.from = "\n" + "Sincerily, \n" + "\n" + from + "\n";
        this.body = "";
    }

    public void addLine(String line) {
        this.body = this.body + line + "\n";
    }

    public String getText() {
        return (this.to + this.body + this.from);
    }

}
