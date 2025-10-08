package sp25_bcs_154;


public class Screen{
                private double price_regular=500;
                private double price_premium=750;
                private double price_vip=1000;
                private double price_recliner=1200;
                Seat seats[][];
		private String screenName;
                private int number_of_rows;
                Seat s=new Seat();
		
//-->Making Parameterized Constructor ====>

		Screen(String name){
			screenName=name;
			seats=new Seat[5][];
			for(int i=0;i<seats.length;i++){
				seats[i]=new Seat[5+i];
				for(int j=0;j<seats[i].length;j++){
					seats[i][j]=new Seat(String.format("R%d-%03d",i+1,j+1),getseattype(i+1,j+1),priceFor(getseattype(i+1,j+1)),true);
			}
}	
}

//-->Making Default Constructor ====>

Screen(){}

//-->Making toString ====>

	public String toString(){
      		StringBuilder str=new StringBuilder();
		str.append(screenName);
		str.append(s.display());
		for(int i=0;i<seats.length;i++)
			for(int j=0;j<seats[i].length;j++)
				str.append("\n"+seats[i][j].toString());	
		return str.toString();
	}

//--> Making Getters & Setters Methods =====>

public String getscreenName(){
      return screenName;
}

public double getprice_regular(){
      return price_regular;
}

public double getprice_premium(){
      return price_premium;
}

public double getprice_vip(){
      return price_vip;
}

public double getprice_recliner(){
      return price_recliner;
}

public int getnumber_of_rows(){
      return number_of_rows;
}

//-->Making book() Method

public boolean book(int row,int seat){                  //by getting row and seat number
           if (!checkBound(row, seat)) {
        System.out.println("Invalid Input! Please try again.");
        return true;
    }
                   if(seats[row-1][seat-1].getisAvailable()){
                        seats[row-1][seat-1].bookSeat();
                        return false;
                   }
                   else{
                         return true;                  
                      }
                 }

//--> Cancel Methods ====>

public boolean cancelbooking(int row,int seat){         //by getting row and seat number
           if (!checkBound(row, seat)) {
        System.out.println("Invalid Input! Please try again.");
        return false;
    }
                   if(!seats[row-1][seat-1].getisAvailable()){
                        seats[row-1][seat-1].cancelBooking();
                        return true;
                   }
                   else{
                         return false;
                       }
                        }

//---> Making getseat() Method for Seat Information ====>

public Seat getseat(int row,int seat){                    //seat information by row and seat
           if (!checkBound(row, seat)) {
        System.out.println("Invalid Input! Please try again.");
        return null;
    }
                return seats[row-1][seat-1];
    }

//---> Making getseattype() Method for Seat Information ====>

public SeatType getseattype(int row, int seat){           //seat type by row and seat
           if (!checkBound(row, seat)) {
        System.out.println("Invalid Input! Please try again.");
        return null;
    } 
        for(int i=0;i<seats.length;i++){
            for(int j=0;j<seats[i].length;j++){
               if((row-1)<=1){
                  return SeatType.REGULAR;
}
               if((row-1)==2){
                  return SeatType.PREMIUM;
}
               if((row-1)==3){
                  return SeatType.VIP;
}
               if((row-1)==4){
                  return SeatType.RECLINER;
}

}
}
                  return null;
}

//---> Making getRowType() Method for Seat Information ====>

public void setRowType(int row,SeatType s,double d){      //set seat info by row,seat-type and price
               if (row<1 || row>seats.length){
        System.out.println("Invalid row number!");
        return;
    }
               for(int i=0;i<seats[row-1].length;i++){
                    seats[row-1][i].setSeatType(s);
                    seats[row-1][i].setprice(d);
}
}

//---> Availability and Seat count Methods ====>

public int totalSeatCount(){                                //for total Seats
            int availableSeat=0;
          for(int i=0;i<seats.length;i++){
            for(int j=0;j<seats[i].length;j++){
                     availableSeat++;
}
} 
             return availableSeat;
}

public int getAvailableSeatCount(){                          //Number of all availble seats
                  int availableSeat=0;
          for(int i=0;i<seats.length;i++){
            for(int j=0;j<seats[i].length;j++){
                  if(seats[i][j].getisAvailable()){
                     availableSeat++;
}
}
}
              return availableSeat;
}

public int getAvailableSeatCount(SeatType s){                //Available Seats by Seat Type
                    int availableSeat=0;
            for(int i=0;i<seats.length;i++){
            for(int j=0;j<seats[i].length;j++){
                  if(seats[i][j].getisAvailable()==true && seats[i][j].gettype()==s){
                     availableSeat++;
}
}
}
              return availableSeat;
}

public Seat getFirstAvailableSeat(SeatType st){               //First available seat of particular type
                   for(int i=0;i<seats.length;i++){
            for(int j=0;j<seats[i].length;j++){
                 if(seats[i][j].getisAvailable()==true && seats[i][j].gettype()==st){
                     System.out.println(s.display());
                     return seats[i][j];
}
}
}        
                 return null;
}

public Seat[] getListAvailableSeat(SeatType s) {
    int count = 0;
    for (int i=0;i<seats.length;i++) {
        for (int j=0;j<seats[i].length;j++) {
            if (seats[i][j].getisAvailable() && seats[i][j].gettype() == s) {
                count++;
    }
    }
    }
    Seat[] list = new Seat[count];
    int index = 0;
    for (int i=0;i<seats.length;i++) {
        for (int j=0;j<seats[i].length;j++) {
            if (seats[i][j].getisAvailable() && seats[i][j].gettype() == s) {
                list[index]=seats[i][j];
                index++;
    }
    }
    }

    return list;
}

//---> Screen Information Methods ====>

public int getRowCount(){                                    //getting number of Rows
      int count=0;
      for(int i=0;i<seats.length;i++){
         count++;
}
      return count;
}

public int getRowLength(int row){                            //Getting number of Seats in a particular row
      int count=0;
         for(int j=0;j<seats[row-1].length;j++){
         count++;
}
      return count;
}

public double priceFor(SeatType s){                          //Getting Price according to seat type.
       if(s==SeatType.REGULAR)
            return getprice_regular();
      else if(s==SeatType.PREMIUM)
            return getprice_premium();
      else if(s==SeatType.VIP)
            return getprice_vip();
      else if(s==SeatType.RECLINER)
            return getprice_recliner();
      else 
            return 0;
}

//--->Making checkbound() Method ====>

                     public boolean checkBound(int row, int col) {
                       if ((row-1)<0 || row>seats.length) {
                        return false;
                        }
                       if ((col-1)<0 || col>seats[row-1].length) {
                        return false;
                        }
                        return true;
                        }

//--->Display Method ====>

         public void displaylayout(){
             for(int i=0;i<seats.length;i++){
            for(int j=0;j<seats[i].length;j++){
                System.out.print("["+seats[i][j].getseatID()+":"+seats[i][j].display_availabilitysymbol()+"]");
}
              System.out.println();
}
              System.out.println("Total : "+totalSeatCount()+", Available : "+getAvailableSeatCount());
}



}