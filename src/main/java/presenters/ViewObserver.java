package presenters;

import java.util.Date;

public interface ViewObserver {
    void onReservationTable(Date date, int tableNo, String name);
    void changeReservationTable(int oldReservationNo, Date reservationDate, int tableNo, String name);

}
