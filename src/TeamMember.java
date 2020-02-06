/**

 @author
 */
public class TeamMember
{
   private String name;
   private Date  startDate;
   

   public TeamMember(String nm, Date date)
   {
	   name = nm;
	   startDate = new Date(date);
   }
   
   //Get Functions Below:
   public String getName() {
	   return name;
   }

   public Date getStartDate()
   {
      return startDate;
   }
   //Get Functions above

   public boolean equals(Object obj)
   {
	  System.out.println("In equals fxn: TeamMember");
	  
      obj = (TeamMember) obj;
      String checker = String.format("%s %s/%s/%s", name, startDate.getMonth(), startDate.getDay(), startDate.getYear());
      boolean valid = checker.equals((obj.toString()));
      
      return valid;
   }

   public String toString()
   {
       //name + " " + startDate;
       return name + " " + String.format("%s/%s/%s", startDate.getMonth(), startDate.getDay(), startDate.getYear());
   }

   public static void main(String [] args){
     System.out.println("In Testbed main");
      //testbed main; you must include test cases that exercise
      //the constructor and all methods in this class.
   }
}
