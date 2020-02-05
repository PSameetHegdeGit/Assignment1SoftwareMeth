import java.util.*;

/**

 @author
 */
/*
 * TODO: 
 * 
 */

public class ProjectManager
{
   Scanner stdin;
   Team cs213;
   public void run()
   {

      boolean done = false;
      stdin = new Scanner(System.in);
      System.out.println("Enter members of teams that you want to add:");
      
      while ( !done ) {
    	  String command = stdin.next();
    	  String name = stdin.next();
    	  String date = stdin.next();
    		  
    	  //Just to test
    	  System.out.println(String.format("%s %s %s", command, name, date));
       		
    	  ///WE MAY HAVE tO CHECK FOR mistyped commands longer than one char
    	  switch (command.charAt(0)){
    	  	case 'A': add(name, date); break;
    	  	case 'R': remove(name, date); break;
            case 'P': print(name, date); break;
            case 'Q': done = true; break;
            default: System.out.println(String.format("command '%s' not supported!", command.charAt(0))); //deal with bad command here
    	  }     
      }
      //write java code before you terminate the program
   } //run()

   private void add(String name, String date)
   {
	   System.out.println("in Add command: Project Manager");
	   System.out.println(String.format("to work with: %s %s", name, date));
	   
	   Date newDate = new Date(date);
	   System.out.println(String.format("month and year: %s %s %s", newDate.getMonth(), newDate.getDay(), newDate.getYear()));
	   
	   if(newDate.isValid()) {
		   System.out.println("Team member is valid so can check if team member can be added to team");
		   //Team member logic down below
		   TeamMember person = new TeamMember(name, newDate);
		   
		   
	   }
	   else {
		   System.out.println(String.format("%s/%s/%s is not a valid date!", newDate.getMonth(), newDate.getDay(), newDate.getYear()));
	   }
      	//must check if the date is valid
	   //must call the contains() method to check if a given
	   //team member is in the team already
   }

   private void remove(String name, String date)
   {
	   System.out.println("in remove command: Project Manager");
	   System.out.println(String.format("to work with: %s %s", name, date));
      //must check if the date is valid

   }

   private void print(String name, String date)
   {
	   System.out.println("in print command: Project Manager");
	   System.out.println(String.format("to work with: %s %s", name, date));
      //must check if the team has 0 members.
   }

  
} //ProjectManager
