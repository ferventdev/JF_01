package javase01.t06;

/**
 * The Record class stores one text record.
 *
 * Created by Aleksandr Shevkunenko on 04.06.2017.
 */
public class Record {
    private String text;

    /** The only constructor accepts a text string. */
    public Record(String text) {
        this.text = text;
    }

    /** Returns the text, stored inside the record object. */
    public String getText() {
        return text;
    }

    /** Sets a new value for the text string inside the record object. */
    public void setText(String text) {
        this.text = text;
    }
}
