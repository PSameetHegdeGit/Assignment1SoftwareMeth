import java.util.StringTokenizer;

/**

 @author
 */
//Can I add methods?

public class Date
{
   private int  day;
   private int  month;
   private int  year;
   
   
   //Below are get and set methods
   public int getDay() {
	   return this.day;
   }
   
   public int getMonth() {
	   return this.month;
   }
   
   public int getYear() {
	   return this.year;
   }
   
   public void setDay(int day) {
	   this.day = day;
   }
   
   public void setMonth(int month) {
	   this.month = month;
   }
   
   public void setYear(int year) {
	   this.year = year;
   }
    //Above are get and set methods
   
   public static boolean isLeapYear(int year)
   {
	   if( year % 4 == 0) {
		   if( year % 100 == 0 ) {
			   if( year % 400 == 0 ) {
				   return true;
			   }
			   else {
				   return false;
			   }
		   }
		   else {
			   return true;
		   }
	   }
	   
	   return false;
	   
   }
   
   
   
   public Date(String d)
   {
	  StringTokenizer dateTokenizer = new StringTokenizer(d);
	  String delim = "/";
	  try {
		  this.month = Integer.parseInt(dateTokenizer.nextToken(delim));
		  this.day = Integer.parseInt(dateTokenizer.nextToken(delim));
		  this.year = Integer.parseInt(dateTokenizer.nextToken(delim));
	  }
	  catch(Exception e){
		  System.out.println("date is malformed. Please reenter Date:");
		  //add some code to handle malformed code --> if don't handle then day, month, and year, will be initialized to default value of 0 
	  }
	 
	 
      //use StringTokenizer to parse the String and create a Date object
   }

   public Date(Date d)
   {
	   day = d.day;
	   month = d.month;
	   year = d.year;
	   
      //this is a constructor
   }

   public boolean isValid()
   {
	   //STILL NEED TO CHECK FOR LEAP YEAR
	   boolean valid;
	   if( month == 2 ) { 
		   boolean leapYear = isLeapYear(year);
		   
		   if( leapYear ) {
			   System.out.println("leap year");
			   valid = ( day < 30 );
		   }
		   else {
			   System.out.println("not leap year");
			   valid = ( day < 29 );
			   return valid;
		   }
		   
	   }
	   
	   

	   if (month < 8) {
		   valid = (month % 2 == 0 && day <= 30) || (month % 2 == 1 && day <= 31);
		   
	   }
	   else { 
		   valid = (month % 2 == 0 && day <= 31) || (month % 2 == 1 && day <= 30);
	   }
	
	
       return valid;
   }

   //Below methods need to be filled
   @Override
   public String toString()
   {
       //use the format "month/day/year"
       return null;
   }

   @Override
   public boolean equals(Object obj)
   {
       return false;
   }
   
   //Below is the test bed main for the date class
   public static void main(String [] args) {
	  System.out.println("This is the test bed main for the Date Class");
	  boolean leap = isLeapYear(2017);
	  
	  System.out.println(leap);
	  
   }
   
}
