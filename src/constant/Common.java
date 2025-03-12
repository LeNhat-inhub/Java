package constant;

import object.Customer;
import other.ReadWriteObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Common {
    public static ReadWriteObject readWriteObject;
    public static Scanner scanner;

    public static ReadWriteObject getReadWriteObject() {
        if(readWriteObject == null) {
            readWriteObject = new ReadWriteObject();
        }
        return readWriteObject;
    }

    public static Scanner getScanner() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }

    public final static String roomPath = "./src/data/room.bin";
    public final static String customerPath = "./src/data/customer.bin";
    public final static String staffPath = "./src/data/staff.bin";
    public final static String roomManagement = "./src/data/room-management.bin";
}
