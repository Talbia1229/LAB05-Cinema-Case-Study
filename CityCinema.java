package sp25_bcs_154;


public class CityCinema {
    private String cityName;
    private Cinema[] cinemas;
    private int count; // logical size

// ---> Making Parameterized Constructor ====> 

    public CityCinema(String cityName, int capacity) {
        this.cityName=cityName;
        cinemas=new Cinema[capacity];
        count=0;
    }

// ---> Making Default Constructor ====> 

    public CityCinema() {
        this("Default City",3);
        preloadCity();
    }

// ---> Making addCinema() Method ====>

    public void addCinema(String name, int screenCount) {
        if (count==cinemas.length) {
            Cinema[] temp=new Cinema[cinemas.length * 2];
            for (int i=0;i<cinemas.length;i++)
                  temp[i] = cinemas[i];
                  cinemas = temp;
        }
        cinemas[count++]=new Cinema(name,screenCount);
        System.out.println("Cinema added: " + name);
    }

// ---> Making removeCinema() Method =====>

    public void removeCinema(String name) {
        for (int i = 0; i < count; i++) {
            if (cinemas[i].toString().contains(name)) {
                for (int j = i; j < count - 1; j++) {
                    cinemas[j] = cinemas[j + 1];
                }
                cinemas[count - 1] = null;
                count--;
                System.out.println("Removed cinema: " + name);
                return;
            }
        }
        System.out.println("Cinema not found!");
    }

// ---> Making findCinema() Method =====>

    public Cinema findCinema(String name) {
        for (int i=0;i<count;i++) {
            if (cinemas[i].toString().contains(name)) {
                return cinemas[i];
            }
        }
        return null;
    }

// ---> Making bookSeat() Method for booking seat in cinema =====>

    public boolean bookSeat(String cinemaName, String screenName, int row, int seat) {
        for (int i=0;i<count;i++) {
            if (cinemas[i].toString().contains(cinemaName)) {
                return cinemas[i].bookSeat(screenName, row, seat);
            }
        }
        System.out.println("Cinema not found!");
        return false;
    }

// ---> Making cancelSeat() Method for canceling seat in cinema =====>

    public boolean cancelSeat(String cinemaName, String screenName, int row, int seat) {
        for (int i = 0; i < count; i++) {
            if (cinemas[i].toString().contains(cinemaName)) {
                return cinemas[i].cancelSeat(screenName, row, seat);
            }
        }
        System.out.println("Cinema not found!");
        return false;
    }

// --->Making getTotalSeats() Method for getting Total number of seats ====>

    public int getTotalSeats() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            total += cinemas[i].getTotalSeats();
        }
        return total;
    }

// --->Making getAvailableSeats() Method for getting Total number of Available seats in cinema ====>

    public int getAvailableSeats() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            total += cinemas[i].getAvailableSeats();
        }
        return total;
    }

    public int getAvailableSeats(SeatType type) {
        int total = 0;
        for (int i = 0; i < count; i++) {
            total += cinemas[i].getAvailableSeats(type);
        }
        return total;
    }

// --- Making findFirstVIPSeat() method for knowing First VIP Seat in cinema ====>

    public String findFirstVIPSeat() {
        for (int i=0;i<count;i++) {
            Cinema c=cinemas[i];
            for (int j=0;j<5;j++) {              //cinema has 5 screens
                Screen s = c.findScreen(j);
                if (s!=null) {
                    Seat vip=s.getFirstAvailableSeat(SeatType.VIP);
                    if (vip!=null) {
                        return String.format("%s > %s > %s (VIP, %.2f PKR)","Cinema-" + (i + 1),"Screen-" + (j + 1),vip.getseatID(),vip.getprice());
                    }
                }
            }
        }
        return "No VIP seat available in the city!";
    }

// ---> Making preloadCity() Method =====>

    public void preloadCity() {
        cinemas[0] = new Cinema("MegaStar", 2);
        cinemas[1] = new Cinema("Galaxy", 3);
        cinemas[2] = new Cinema("StarView", 2);
        count = 3;
    }

// ---> Making displayAll() Method for Displaying Details of cinemassss ====>

    public void displayAll() {
        System.out.println("City: " + cityName);
        for (int i = 0; i < count; i++) {
            System.out.println("\n" + cinemas[i]);
            cinemas[i].displayAllLayouts();
        }
        System.out.println("\nTotal Seats in City: " + getTotalSeats());
        System.out.println("Available Seats in City: " + getAvailableSeats());
    }

// ---> Making toString() Method =====>

    public String toString() {
        return String.format(
            "City: %-15s | Cinemas: %-2d | Total Seats: %-3d | Available: %-3d",
            cityName, count, getTotalSeats(), getAvailableSeats()
        );
    }
}