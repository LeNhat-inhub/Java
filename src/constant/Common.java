package constant;

import object.Customer;
import other.ReadWriteObject;

import java.util.ArrayList;
import java.util.List;

public class Common {
    public static ReadWriteObject readWriteObject;

    static {
        readWriteObject = new ReadWriteObject();
    }
}
