package sp25_bcs_154;

public class Seat{

	 private String seatID;
	 private SeatType type;
         private double price;
         private boolean isAvailable;

//--> Now I am making parameterized Constructor=====>

	Seat(String seatID,SeatType type,double price,boolean isAvailable){
		this.seatID=seatID;
		this.type=type;
                this.price=price;
                this.isAvailable=isAvailable;
	}

//--> Now I am making default Constructor=====>

        Seat(){}

//-->Using toString() method=====>

@Override
public String toString(){
	return String.format("\t%-15s  %-15s  %7.2f \t %-20s",getseatID(),gettype(),getprice(),display_availability(getisAvailable()));
}

//--> Making Display() Function to Display Headings ====>

public String display(){

         {
           return"\n\tSEAT ID \t SEAT TYPE \t TICKET PRICE \t AVAILABILITY";
}
}

//--> Making Setters & Getters ====>

public void setSeatType(SeatType type){
           this.type=type;
}
public void setprice(double price){
           this.price=price;
}

public double setprice(SeatType t){
      if(t==SeatType.REGULAR)
            return 500;
      else if(t==SeatType.PREMIUM)
            return 750;
      else if(t==SeatType.VIP)
            return 1000;
      else if(t==SeatType.RECLINER)
            return 1200;
      else 
            return 0;
}

    public String getseatID(){
          return this.seatID;
}

public SeatType gettype(){
          return this.type;
}

public double getprice(){
          return this.price;
}

public boolean getisAvailable(){
          return this.isAvailable;
}


//--->Book & Cancel Method


public boolean bookSeat(){
      return isAvailable=false;
}

public boolean cancelBooking(){
      return isAvailable=true;
}

//-->Making display_availability() Method ====>

   public String display_availability(boolean isAvailable){
               if(isAvailable==true){
                  return "Available";}
               else
                  return "Booked";
}

//-->Making display_availabilitysymbol() Method ====>

   public String display_availabilitysymbol(){
               if(getisAvailable()==true){
                  return "A";}
               else
                  return "B";
}
}