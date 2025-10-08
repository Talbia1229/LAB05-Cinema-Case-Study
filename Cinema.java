package sp25_bcs_154;


public class Cinema{

	String name;
        Screen screen;
	Screen screens[];
        int count;


	Cinema(String name,int n){
		this.name=name;
		screens=new Screen[n];
		for(int i=0;i<screens.length;i++)
			screens[i]=new Screen("Screen "+(i+1));

	}
public Cinema() {
        this("Default Branch", 3);
        screens[0]=new Screen("Screen 1");
        screens[1]=new Screen("Screen 2");
        screens[2]=new Screen("Screen 3");
        count = 3;
    }


	public String toString(){
		StringBuilder str=new StringBuilder();
		str.append("\n\n======"+name+"======\n");
		for(int i=0;i<screens.length;i++)
		{
		str.append("\n"+screens[i].toString());
		}
		return str.toString();
	}

// ---> Making addScreen() Method =====>

    public void addScreen(String name) {
        if (count==screens.length) {
            Screen temp[]=new Screen[screens.length*2];
            for (int i=0;i<screens.length;i++) {
                temp[i]=screens[i];
            }
            screens=temp;
        }
        screens[count++]=new Screen(name);
        System.out.println("Screen added: " + name);
    }

// ---> Making findScreen() by name Method ====>

    public Screen findScreen(String name) {
        for (int i=0;i<count;i++) {
            if (screens[i].getscreenName().equals(name)) {
                return screens[i];
            }
        }
        return null;
    }

// ---> Making findScreen() by index Method ====>

    public Screen findScreen(int index) {
        if (index>=0&&index<count)
            return screens[index];
        else
            return null;
    }

// ---> Making bookSeat() for Booking seat ====>

    public boolean bookSeat(String screenName, int row, int seat) {
        Screen s=findScreen(screenName);
        if (s!=null) {
            return s.book(row, seat);
        }
        System.out.println("Screen not found!");
        return false;
    }

// ---> Making cancelSeat() for canceling seat ====>

    public boolean cancelSeat(String screenName, int row, int seat) {
        Screen s=findScreen(screenName);
        if (s!=null) {
            return s.cancelbooking(row, seat);
        }
        System.out.println("Screen not found!");
        return false;
    }

// ---> Making getTotalSeats() Method for getting Total number of seats ====>

    public int getTotalSeats() {
        int total=0;
        for (int i=0;i<count;i++) {
            total += screens[i].totalSeatCount();
        }
        return total;
    }

// ---> Making getAvailableSeats() Method for getting number of available seats ====>

    public int getAvailableSeats() {
        int total=0;
        for (int i=0;i<count;i++) {
            total+=screens[i].getAvailableSeatCount();
        }
        return total;
    }

    public int getAvailableSeats(SeatType type) {
        int total=0;
        for (int i=0;i<count;i++) {
            total += screens[i].getAvailableSeatCount(type);
        }
        return total;
    }

// ---> Making displayAllLayouts() Method for Displaying ====>

    public void displayAllLayouts() {
        System.out.println("Cinema Branch: " + name);
        for (int i = 0; i < count; i++) {
            System.out.println("\nScreen " + (i + 1) + ": " + screens[i].getscreenName());
            screens[i].displaylayout();
        }
    }
}