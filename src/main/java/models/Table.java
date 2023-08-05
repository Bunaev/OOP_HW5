package models;

import java.util.ArrayList;
import java.util.Collection;

public class Table {
    private  final int no;
    private static int counter;
    {
        no = ++counter;
    }

    static final Collection<Reservation> reservations = new ArrayList<>();
    public  Collection<Reservation> getReservations(){
        return reservations;
    }

    public  int getNo(){
        return  no;
    }

    @Override
    public String toString() {
        return String.format("Столик №%d", no);
    }
}
