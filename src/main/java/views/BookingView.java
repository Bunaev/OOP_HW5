package views;

import models.Table;
import presenters.View;
import presenters.ViewObserver;

import java.util.Collection;
import java.util.Date;

public class BookingView implements View {
    private ViewObserver observer;

    public  void showTables(Collection<Table> tables){
        for (Table table: tables){
            System.out.println(table);
        }
    }
    public void showReservationTableResult(int reservationId){
        System.out.printf("Столик успешно забронирован. Номер Вашей брони: №%d\n", reservationId);
    }

    @Override
    public void setObserver(ViewObserver observer) {
        this.observer = observer;
    }

    public void reservationTable(Date date, int tableNo, String name){
        observer.onReservationTable(date,tableNo,name);
    }

    public void showChangeReservationTableResult(int reservationId){
        System.out.printf("Бронь успешно изменена. Новый номер брони: №%d\n", reservationId);
    }
    /**
     * Удаление старого резерва столика. Бронирование столика на новое время.
     * @param oldReservationDate
     * @param reservationDate
     * @param tableNo
     * @param name
     * @return
     */
    public void changeReservationTable(int oldReservationDate, Date reservationDate, int tableNo, String name){
        observer.changeReservationTable(oldReservationDate, reservationDate, tableNo, name);
    }
}
