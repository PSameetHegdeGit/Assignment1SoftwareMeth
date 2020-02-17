/**
This class defines the name and starting date of a team member
Its methods are called to check for equivalent members and to format a member's properties as a string
@author Sameet Hegde, Abhijit Bhatt
*/
public class TeamMember
{
   private String name;
   private Date  startDate;
   
   /**
   Constructor that sets name and start date of a team member
   @param nm  name of member
   @param date  start date of member
    */
   public TeamMember(String nm, Date date)
   {
	   name = nm;
	   startDate = new Date(date);
   }
   
   /**
   Below Function Checks to see if TeamMembers are equal to one another 
   @param obj object to be compared to class
   */
   public boolean equals(Object obj)
   {

      String checker = String.format("%s %s", name, startDate.toString());
      
      boolean valid = checker.equals((obj.toString()));
      
      return valid;
   }

   /**
   Formats name and date into a string
   @return name and date as String
   */
   public String toString()
   {   
       return name + " " + startDate.toString();
   }

   /**
   Testbed main to test every method
   @param args
   */
   public static void main(String [] args){
     System.out.println("In Testbed main: TeamMember\n");
     
     //Test 1
     System.out.println("Test 1: Check to see if equals returns correct boolean value when comparing two team members");
     TeamMember test1Member = new TeamMember("Sam", new Date("1/2/2012"));
     
     boolean isEqual = test1Member.equals(new TeamMember("Sam", new Date("1/2/2012")));
     System.out.println("input: Sam 1/2/2012 & Sam 1/2/2012 | " + " output: " + isEqual);
     
     boolean notEqual = test1Member.equals(new TeamMember("Rick", new Date("2/3/2012")));
     System.out.println("input: Sam 1/2/2012 & Rick 2/3/2012 | " + " output: " + notEqual);
     
     boolean notEqual2 = test1Member.equals(new TeamMember("Sam", new Date("3/1/1999")));
     System.out.println("input: Sam 1/2/2012 & Sam 3/1/1999 |" + " output: " + notEqual2);
     
     boolean notEqual3 = test1Member.equals(new TeamMember("George", new Date("1/2/2012")));
     System.out.println("input: Sam 1/2/2012 & George 1/2/2012 |" + " output: " + notEqual3 + "\n");
    
     //Test 2: Check to see if constructor is initializing data members w/ parameters
     System.out.println("Test 2: Check to see if constructor is initializing data members w/ parameters");
     TeamMember test2Membera = new TeamMember ("Yussef", new Date("12/2/1999"));
     System.out.println("name input: Yussef | " + "name output: " + test2Membera.name);
     System.out.println("Date input: 12/2/1999 |" + " Date output: " + test2Membera.startDate.toString());
     
     TeamMember test2Memberb = new TeamMember("Bob", new Date("12/2"));
     System.out.println("name input: Bob |" + " name output: " + test2Memberb.name);
     System.out.println("Date input: 12/2 |" + " date output: " + test2Memberb.startDate.toString());
     
   }
}
