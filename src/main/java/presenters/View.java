package presenters;

import models.Table;

import java.util.Collection;
import java.util.Date;

public interface View {
    /**
     * Метод отображения всех столиков в приложении
     * @param tables
     */
    void showTables(Collection<Table> tables);

    /**
     * Метод позволяет установить наблюдателя, отслеживающего действия пользователя
     * @param observer
     */
    void setObserver(ViewObserver observer);

    /**
     * Зарегистировать столик на дату
     * @param date дата
     * @param tableNo номер столика
     * @param name имя клиента
     */
    void reservationTable(Date date, int tableNo, String name);

    /**
     * Отобразить результат бронирования
     * @param reservationId номер брони
     */
    void showReservationTableResult(int reservationId);

    /**
     * Изменение брони
     * @param oldReservationNo
     * @param reservationDate
     * @param tableNo
     * @param name
     * @return
     */
    void changeReservationTable(int oldReservationNo, Date reservationDate, int tableNo, String name);
    void showChangeReservationTableResult(int reservationId);
}
