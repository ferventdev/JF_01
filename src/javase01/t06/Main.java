package javase01.t06;

/**
 * The Main class here is used to test the Notepad and Record classes.
 * Created by Aleksandr Shevkunenko on 04.06.2017.
 */
public class Main {
    public static void main(String[] args) {
        Notepad pad = new Notepad(4);
        System.out.println("The notepad was just created.");
        pad.watchAllRecords();
        System.out.printf("Capacity = %d, number of records = %d.%n%n", pad.currentCapacity(), pad.getNumberOfRecords());


        System.out.println("Let's add some records to the notepad.");
        for (int i = 1; i <= 11; i++) System.out.print(pad.addRecord(new Record("Rec #" + i + ". ")) + " ");
        System.out.print(pad.addRecord(null) + " ");    // check adding of a null value
        System.out.println();
        pad.watchAllRecords();
        System.out.printf("Capacity = %d, number of records = %d.%n%n", pad.currentCapacity(), pad.getNumberOfRecords());


        System.out.println("Let's edit the existing records in the notepad.");
        try {
            pad.editRecord(pad.getNumberOfRecords(), new Record("This edit won't be allowed."));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        try {
            pad.editRecord(pad.getNumberOfRecords() - 1, null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("The following records were edited:");
        for (int i = 1, n = pad.getNumberOfRecords() - 2; i <= n; i++)
            System.out.print(pad.editRecord(i - 1, new Record("New rec #" + i + ". ")) + " ");
        System.out.println();
        pad.watchAllRecords();
        System.out.printf("Capacity = %d, number of records = %d.%n%n", pad.currentCapacity(), pad.getNumberOfRecords());


        System.out.println("Let's remove some records from the notepad.");
        try {
            pad.removeRecord(pad.getNumberOfRecords()); // this won't be allowed
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("The following records were removed:");
        for (int i = 0, n = pad.getNumberOfRecords() - 4; i < n; i++)
            System.out.print(pad.removeRecord(0) + " ");
        System.out.println();
        pad.watchAllRecords();
        System.out.printf("Capacity = %d, number of records = %d.%n%n", pad.currentCapacity(), pad.getNumberOfRecords());


        System.out.println("Let's remove the rest of the records.");
        System.out.println("The following records were removed:");
        for (int i = 0, n = pad.getNumberOfRecords(); i < n; i++)
            System.out.print(pad.removeRecord() + " ");
        System.out.println();
        pad.watchAllRecords();
        System.out.printf("Capacity = %d, number of records = %d.%n%n", pad.currentCapacity(), pad.getNumberOfRecords());
    }
}
