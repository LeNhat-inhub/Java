package object;

import java.util.UUID;

public class Customer extends User {
    private String identityNumber;
    private String phone;

    public Customer() {
        super();
    }

    public Customer(UUID id, String phone, String identityNumber, String name) {
        this.identityNumber = identityNumber;
        this.phone = phone;
        super(id, name);
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Override
    public String toString() {
        return "Customer{" + "name=" + getName() +
                "id='" + getId() + '\'' +
                ", identity number=" + identityNumber +
                ", phone=" + phone +
                '}';
    }
}

