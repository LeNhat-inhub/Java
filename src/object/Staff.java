package object;

import java.util.UUID;

public class Staff extends User {
    private String identityNumber;

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public Staff(UUID id,String identityNumber, String name) {
        super(id, name);
        this.identityNumber = identityNumber;
    }

    public Staff() {
        super();
    }



    @Override
    public String toString() {
        return "Staff{" + "id=" + getIdentityNumber() + ", name=" + getName() + '}';
    }
}
