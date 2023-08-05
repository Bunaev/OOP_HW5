import models.TableModel;
import presenters.BookingPresenter;
import presenters.Model;
import presenters.View;
import views.BookingView;

import java.util.Date;

public class Program {
    public static void main(String[] args) {
        View view = new BookingView();
        Model model = new TableModel();

        BookingPresenter bookingPresenter = new BookingPresenter(view, model);
        bookingPresenter.showTables();
        view.reservationTable(new Date(), 3, "Станислав");
        view.changeReservationTable(1001, new Date(), 4, "Станислав");
    }
}
