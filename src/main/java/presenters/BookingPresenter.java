package presenters;

import models.Table;
import java.util.Collection;
import java.util.Date;

public class BookingPresenter implements ViewObserver{
    private  final View view;
    private final Model model;

    public BookingPresenter(View view, Model model) {
        this.view = view;
        this.model = model;
        view.setObserver(this);
    }
    private Collection<Table> loadTables(){
        return model.loadTables();
    }

    public void showTables(){
        view.showTables(loadTables());
    }
    private void showReservationTableResult(int reservationId){
        view.showReservationTableResult(reservationId);
    }

    private void showChangeReservationTableResult(int reservationId){
        view.showChangeReservationTableResult(reservationId);
    }

    /**
     * Произошло событие: пользователь нажал на кнопку резерва столика
     * @param date
     * @param tableNo
     * @param name
     */
    @Override
    public void onReservationTable(Date date, int tableNo, String name) {
        int reservationId = model.reservationTable(date, tableNo, name);
        showReservationTableResult(reservationId);
    }
    @Override
    public void changeReservationTable(int oldReservationNo, Date reservationDate, int tableNo, String name){
        int newReservationId = model.changeReservationTable(oldReservationNo, reservationDate, tableNo, name);
        showChangeReservationTableResult(newReservationId);
    }
}
