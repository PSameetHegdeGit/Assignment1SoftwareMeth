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
   
   //Below Function Checks to see if TeamMembers are equal to one another 
   public boolean equals(Object obj)
   {

      String checker = String.format("%s %s", name, startDate.toString());
      
      boolean valid = checker.equals((obj.toString()));
      
      return valid;
   }

   //Formats name and date into a string
   public String toString()
   {   
       return name + " " + startDate.toString();
   }

   public static void main(String [] args){
     System.out.println("In Testbed main: TeamMember\n");
     
     //Test 1
     System.out.println("Test 1: Check to see if equals returns correct boolean value when comparing two team members");
     TeamMember member = new TeamMember("Sam", new Date("1/2/2012"));
     
     boolean isEqual = member.equals(new TeamMember("Sam", new Date("1/2/2012")));
     System.out.println("input: Sam 1/2/2012 & Sam 1/2/2012 | " + " output: " + isEqual);
     
     boolean notEqual = member.equals(new TeamMember("Rick", new Date("2/3/2012")));
     System.out.println("input: Sam 1/2/2012 & Rick 2/3/2012 | " + " output: " + notEqual + "\n");
     
    
     //Test 2: Check to see if constructor is initializing data members w/ parameters
     
   }
}
