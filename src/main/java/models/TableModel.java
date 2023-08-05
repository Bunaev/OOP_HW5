package models;

import presenters.Model;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TableModel implements Model {
    private  Collection<Table> tables;

    /**
     * Получить список всех столиков в ресторане
     * @return
     */
    public Collection<Table> loadTables(){
        if (tables == null){
            tables = new ArrayList<>();
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }
        return tables;
    }
    public int reservationTable(Date reservationDate, int tableNo, String name){
        for (Table table: loadTables()){
            if (table.getNo() == tableNo){
                Reservation reservation = new Reservation(reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        throw new RuntimeException("Некорректный номер столика!");
    }

    /**
     * Отмена старой брони по номеру и бронирование на новую дату и время.
     * @param oldReservationNo
     * @param reservationDate
     * @param tableNo
     * @param name
     * @return
     */
    public int changeReservationTable(int oldReservationNo, Date reservationDate, int tableNo, String name) {
        for (Reservation reservation: Table.reservations) {
            if (reservation.getId() == oldReservationNo){
                Reservation newReservation = new Reservation(reservationDate, name);
                Table.reservations.add(newReservation);
                Table.reservations.remove(reservation);
                return newReservation.getId();
            }
        }
        throw new RuntimeException("Некорректный номер брони!");
    }
}
