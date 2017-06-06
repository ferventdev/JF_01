package javase01.t06;

import java.util.Arrays;

/**
 * The Notepad class stores multiple text records.
 * This class is not threadsafe.
 * Created by Aleksandr Shevkunenko on 04.06.2017.
 */
public class Notepad {
    private static final int DEFAULT_CAPACITY = 1;
    private Record[] records;
    private int numberOfRecords = 0;

    /** Constructs the Notepad object with the default storage capacity. */
    public Notepad() {
        this(DEFAULT_CAPACITY);
    }

    /** Constructs the Notepad object with the specified storage capacity (if it exceeds the default capacity). */
    public Notepad(int capacity) {
        records = capacity > DEFAULT_CAPACITY ? new Record[capacity] : new Record[DEFAULT_CAPACITY];
    }

    /** Prints all records in the notepad to the standard output. */
    public void watchAllRecords() {
        System.out.println("All records in the notepad:");
        for (Record rec : records) System.out.print(rec + "  ");
        System.out.println();
    }

    /** Returns the current capacity of the notepad
     * (is equal to the backing array length, currently used to store the records). */
    public int currentCapacity() {
        return records.length;
    }

    /** Returns the number of records in the notepad */
    public int getNumberOfRecords() {
        return numberOfRecords;
    }

    /** Adds a record to the notepad.
     * If the current record storage (backing array) is full, the storage is auto expanded so it may store more records.
     * @param rec a record to be added
     * @return false if a record to be added is null, otherwise true */
    public boolean addRecord(Record rec) {
        if (rec == null) return false;
        if (storageIsFull()) records = Arrays.copyOf(records, records.length * 2);
        records[numberOfRecords] = rec;
        numberOfRecords++;
        return true;
    }

    /** Removes and returns the record at the specified index.
     * @param recordIndex index of the record to be removed
     * @return the removed record
     * @throws IndexOutOfBoundsException if recordIndex parameter exceeds the number of records in the notepad */
    public Record removeRecord(int recordIndex) {
        if (recordIndex >= numberOfRecords)
            throw new IndexOutOfBoundsException("Record index cannot exceed the number of records.");
        Record removedRecord = records[recordIndex];
        numberOfRecords--;
        if (DEFAULT_CAPACITY <= numberOfRecords && numberOfRecords <= records.length / 4) {
            // we'll reallocate data to a shorter array
            System.out.print("***" + recordIndex + " ");
            Record[] destination = new Record[numberOfRecords * 2];
            System.arraycopy(records, 0, destination, 0, recordIndex);
            System.arraycopy(records, recordIndex + 1, destination, recordIndex, numberOfRecords - recordIndex);
            records = destination;
        } else if (recordIndex == numberOfRecords) {    // no reallocation; the last record was removed
            System.out.print("**");
            records[numberOfRecords] = null;
        } else {
            // no reallocation, but we need to "put together" two parts of our array because of the removed record "in the middle"
            System.out.print("*");
            System.arraycopy(records, recordIndex + 1, records, recordIndex, numberOfRecords - recordIndex);
            records[numberOfRecords] = null;
        }
        return removedRecord;
    }

    /** Removes and returns the last record in the notepad. */
    public Record removeRecord() {
        return removeRecord(numberOfRecords - 1);
    }

    /** Replaces the record at the specified record index with a new record.
     * @param recordIndex index of the record to be edited
     * @param newRecord new record that is to replace the current record
     * @return the record before it was edited
     * @throws IndexOutOfBoundsException if recordIndex parameter exceeds the number of records in the notepad
     * @throws IllegalArgumentException if a new record is null */
    public Record editRecord(int recordIndex, Record newRecord) {
        if (recordIndex >= numberOfRecords)
            throw new IndexOutOfBoundsException("Record index cannot exceed the number of records.");
        if (newRecord == null) throw new IllegalArgumentException("New record must be a non-null value.");
        Record oldRecord = records[recordIndex];
        records[recordIndex] = newRecord;
        return oldRecord;
    }

    // Returns true, if the current storage is full of records.
    private boolean storageIsFull() {
        return records.length <= numberOfRecords;
    }
}
