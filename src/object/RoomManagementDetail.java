package object;

import java.io.Serializable;
import java.util.Objects;

public class RoomManagementDetail implements Serializable {
    private Room room;
    private Long invoicePrice;

    public RoomManagementDetail(Room room, Long invoicePrice) {
        this.room = room;
        this.invoicePrice = invoicePrice;
    }

    public RoomManagementDetail() {
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Long getInvoicePrice() {
        return invoicePrice;
    }

    public void setInvoicePrice(Long invoicePrice) {
        this.invoicePrice = invoicePrice;
    }

    @Override
    public String toString() {
        return "RoomManagementDetail{" +
                "room=" + (room != null ? room.toString() : "null") +
                ", invoicePrice=" + invoicePrice +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomManagementDetail that = (RoomManagementDetail) o;
        return Objects.equals(room, that.room) &&
                Objects.equals(invoicePrice, that.invoicePrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(room, invoicePrice);
    }

}
