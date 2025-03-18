package object;

import java.io.Serializable;

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
                "room=" + room +
                ", invoicePrice=" + invoicePrice +
                '}';
    }
}
