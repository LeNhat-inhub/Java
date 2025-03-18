package object;

import java.io.Serializable;
import java.time.LocalDate;

public class RoomAvailable implements Serializable {
    private Room room;
    private LocalDate startDate;
    private LocalDate endDate;

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public RoomAvailable(Room room, LocalDate startDate, LocalDate endDate) {
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
    }

}
