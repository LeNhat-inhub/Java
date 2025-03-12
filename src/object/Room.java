package object;

import java.io.Serializable;

public class Room  implements Serializable {
    private String id;
    private int capacity;
    private Long price;
    private String status;
    public Room() {}

    public Room(String id, int capacity, Long price, String status) {
        this.id = id;
        this.capacity = capacity;
        this.price = price;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id='" + id + '\'' +
                ", capacity=" + capacity +
                ", price=" + price +
                '}';
    }
}
