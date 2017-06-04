package javase01.t06;

import java.util.Arrays;

/**
 * The Notepad class stores multiple text records.
 * This class is not threadsafe.
 * Created by Aleksandr Shevkunenko on 04.06.2017.
 */
public class Notepad {
    private static final int INITIAL_CAPACITY = 2;
    private Record[] records;
    private int numberOfRecords = 0;

    public Notepad() {
        this(INITIAL_CAPACITY);
    }

    public Notepad(int capacity) {
        records = new Record[capacity];
    }

    public void watchAllRecords() {
        System.out.println("All records in the notepad:");
        for (Record rec : records) System.out.println(rec);
    }

    public boolean addRecord(Record rec) {
        if (rec == null) return false;
        if (arrayIsFull()) records = Arrays.copyOf(records, records.length * 2);
        records[numberOfRecords] = rec;
        numberOfRecords++;
        return true;
    }

//    public Record removeRecord() {
//
//    }

    public Record editRecord(int recordIndex, Record newRecord) {
        if (recordIndex >= numberOfRecords)
            throw new IndexOutOfBoundsException("Record index cannot exceed the number of records.");
        if (newRecord == null) throw new IllegalArgumentException("New record must be a non-null value.");
        Record oldRecord = records[recordIndex];
        records[recordIndex] = newRecord;
        return oldRecord;
    }

    private boolean arrayIsFull() {
        return records.length == numberOfRecords;
    }
}
