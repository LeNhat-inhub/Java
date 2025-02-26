package object;

import java.util.UUID;

public class Staff extends User {
    public Staff(UUID id, String name) {
        super(id, name);
    }


    @Override
    public String toString() {
        return "Staff{" + "id=" + getId() + ", name=" + getName() + '}';
    }
}
