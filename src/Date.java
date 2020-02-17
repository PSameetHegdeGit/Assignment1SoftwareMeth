import java.util.StringTokenizer;


/**

 @author
 */


public class Date
{
   private int  day;
   private int  month;
   private int  year;
   
   
   
   //Below method checks to see if a leap year is valid
   public static boolean isLeapYear(int year)
   {
	   if( year % Month.QUADRENNIAL == 0) {
		   if( year % Month.CENTENNIAL == 0 ) {
		       if( year % Month.QUATERCENTENNIAL == 0 ) {
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
   
   
   //Constructor that takes a string formatted date and sets class variables as values nested in string 
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
		  System.out.println("date is malformed!");
	  }
   }

   //Constructor that sets Date = dates of another Date
   public Date(Date d)
   {
	   day = d.day;
	   month = d.month;
	   year = d.year;
   }
   
   
   //Below Function checks to see if a date is valid 
   public boolean isValid()
   {
	   // Check to make sure if month is within a valid range
	   if( month < Month.JAN || month > Month.DEC || day < 1 || year < 1 ) {
		   return false;
	   }
	   
	   
	   boolean valid;
	   
	   //if Month is Feb, check if year is LeapYear by calling helper method isLeapYear
	   if( month == Month.FEB ) { 
		   boolean leapYear = isLeapYear(year);
		   
		   if( !leapYear ) {
			   valid = ( day <= 28 );
		   }
		   else {
			   valid = ( day <= 29 );
		   }
		   
		   return valid;
	   }
	   //If Month is not February, check to see if month and day are valid dates 
	   else {
		  
		   if (month < Month.AUG) {
			   valid = (month % 2 == 0 && day <= Month.DAYS_EVEN) || (month % 2 == 1 && day <= Month.DAYS_ODD);
			   
		   }
		   else { 
			   valid = (month % 2 == 0 && day <= Month.DAYS_ODD) || (month % 2 == 1 && day <= Month.DAYS_EVEN);
		   }
		   
		   return valid;
		   
	   }
   }

   
   @Override
   //Below method returns string format of date
   public String toString()
   {
       return String.format("%s/%s/%s", month, day, year);
   }

   @Override
   public boolean equals(Object obj)
   {
	   String checker = String.format("%s/%s/%s", month, day, year);
	      
	   boolean valid = checker.equals((obj.toString()));
	      
	   return valid;
   }
   
   //Below is the test bed main for the date class
   public static void main(String [] args) {
	  System.out.println("Below is the test bed main for the Date Class\n");
	  
	  System.out.println("Test 1: Test leapyear Fxn to confirm if leap year fxn is working ");
	  boolean notLeap = isLeapYear(2017);
	  System.out.println("input: 2017 |" + " output: " + notLeap);
	  boolean isLeap = isLeapYear(2020);
	  System.out.println("input: 2020 |" + " output: " + isLeap + "\n");
	  
	  //Test 2: 
	  System.out.println("Test 2: confirm if Date(String d) is outputting the correct date");
	  Date dateTest2 = new Date("05/12/1999");
	  System.out.println("input: '5/12/1999' |"  + " output: " + dateTest2.toString() + "\n");
	  
	  //Test 3: check to see if isValid is out
	  System.out.println("Test 3: check to see if isValid is checking for valid dates");
	  Date dateTest3a = new Date("06/13/2019");
	  Date dateTest3b = new Date("13/12/1999");
	  Date dateTest3c = new Date ("2/30/2020");
	  Date dateTest3d = new Date ("3/32/1998");
	  
	  System.out.println("input: '06/13/2019' |" + " output: " + dateTest3a.isValid());
	  System.out.println("input: '13/12/1999' |" + " output: " + dateTest3b.isValid());
	  System.out.println("input: '2/30/2020' |" + " output: " + dateTest3c.isValid());
	  System.out.println("input: '3/32/1998' |" + " output: " + dateTest3d.isValid() + "\n");
	  
	  //Test 4: Check to see if constructor Date(Date d) is working properly using equals fxn
	  System.out.println("test 4: Check to see if constructor Date(Date d) is working properly using equals fxn");
	  Date dateTest4Param = new Date("5/19/1999");
	  Date dateTest4Main = new Date(dateTest4Param);
	  
	  boolean equalDates = dateTest4Main.equals(dateTest4Param);
	  boolean notEqualDates = dateTest4Main.equals("3/2/1999");
	  System.out.println("input: Date objs. '5/19/1999' and '5/19/1999' |" + " output: " + equalDates);
	  System.out.println("input: Date objs. '5/19/1999' and '3/2/1999' |" + " output: " + notEqualDates);
   }
   
}
