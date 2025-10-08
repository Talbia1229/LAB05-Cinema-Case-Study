package sp25_bcs_154;


public class Screendemo{
public static void main(String[] args) {
        Screen s1 = new Screen("Screen-1");

        System.out.println("\n<<----------Seats Count ---------->>\n");
        System.out.println("\nTotal Seats: " + s1.totalSeatCount());
        System.out.println("Available Seats: " + s1.getAvailableSeatCount());

        System.out.println("\n<<----- Compact Layout ----->>\n");
        s1.displaylayout();


        System.out.println("\n<<---------- Booking Seats ---------->>\n");
        System.out.println("Booking seat R1-001...");
        s1.book(1, 1);
        System.out.println("Booking seat R3-002...");
        s1.book(3, 2);
        System.out.println("Booking seat R5-003...");
        s1.book(5, 3);

        System.out.println("\n<<----Layout After Booking ---->>\n");
        s1.displaylayout();

        System.out.println("\n<<---------- Cancelling Seat ---------->>\n");
        System.out.println("Cancelling seat R3-002...");
        s1.cancelbooking(3, 2);

        System.out.println("\n<<---- Layout After Cancellation ---->>\n");
        s1.displaylayout();

        System.out.println("\n<<---- Seat Information ---->>\n");
        Seat seat = s1.getseat(5, 3);
            System.out.println("Seat ID: " + seat.getseatID());
            System.out.println("Type: " + seat.gettype());
            System.out.println("Price: " + seat.getprice());
            System.out.println("Available: " + seat.getisAvailable());

        System.out.println("\n<<----Available Seat Counts by Type---->>\n");
        System.out.println("REGULAR: " + s1.getAvailableSeatCount(SeatType.REGULAR));
        System.out.println("PREMIUM: " + s1.getAvailableSeatCount(SeatType.PREMIUM));
        System.out.println("VIP: " + s1.getAvailableSeatCount(SeatType.VIP));
        System.out.println("RECLINER: " + s1.getAvailableSeatCount(SeatType.RECLINER));

        System.out.println("\n<<---------- First Available Seat (VIP) ---------->>\n");
        Seat vipSeat = s1.getFirstAvailableSeat(SeatType.VIP);
        System.out.println(vipSeat);
        
        System.out.println("\n<<---------- Changing Row Type ---------->>\n");
        System.out.println("Changing Row 2 to PREMIUM, price to 900...");
        s1.setRowType(2, SeatType.PREMIUM, 900);

        System.out.println("\n<<---------- After Row Type Update ---------->>\n");
        s1.displaylayout();


        System.out.println("\n<<--- List of Available PREMIUM Seats --->>\n");
        Seat[] premiumList = s1.getListAvailableSeat(SeatType.PREMIUM);
        for (int i = 0; i < premiumList.length; i++) {
        System.out.print(premiumList[i].getseatID() + "\n ");
        }
        System.out.println();

        System.out.println("\n<<---- SUMMARY ---->>\n");
        System.out.println("Screen Name: " + s1.getscreenName());
        System.out.println("Total Rows: " + s1.getRowCount());
        System.out.println("Seats in Row 1: " + s1.getRowLength(1));
        System.out.println("Total Available Seats: " + s1.getAvailableSeatCount());
        System.out.println("Total Seats: " + s1.totalSeatCount());

        System.out.println("\n<<----- Final Detailed Layout ----->>\n");
        System.out.println(s1);
    }
}