package sp25_bcs_154;


public class Seatdemo {
    public static void main(String[] args) {

        Seat s1 = new Seat("R1-001", SeatType.REGULAR, 500, true);
        Seat s2 = new Seat("R1-002", SeatType.PREMIUM, 750, true);
        Seat s3 = new Seat("R1-003", SeatType.VIP, 1000, true);

//--------------->> Display all seat details-------------------->>

    System.out.println(s1.display());
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

//--------------->>  Book a seat ------------------------->>

        System.out.println("\nBooking seat " + s2.getseatID() + "...");
        s2.bookSeat();

//--------------->>  updated info ---------------->>

    System.out.println(s1.display());
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

//--------------->> Cancel booking ----------------->>

        System.out.println("\nCanceling seat "+ s2.getseatID() + "...");
        s2.cancelBooking();

//---------------->> final state ------------------>>
    System.out.println(s1.display());
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}