package object;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class RoomManagementDetail implements Serializable {
    private Room room;
    private Long invoicePrice;
    private LocalDate startDate;
    private LocalDate endDate;

    public RoomManagementDetail(Room room, Long invoicePrice, LocalDate startDate, LocalDate endDate) {
        this.room = room;
        this.invoicePrice = invoicePrice;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(endDate);
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    public String getRoomId(){
        return room.getId();
    }

    @Override
    public String toString() {
        return "RoomManagementDetail{" +
                "room=" + (room != null ? room.toString() : "null") +
                ", invoicePrice=" + invoicePrice + ", startDate=" + startDate + ", endDate=" + endDate +
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
