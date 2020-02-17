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
   Team cs213 = new Team();
   
   //Function checks input, organizes input into name and date, and runs either add, remove, print, or quit depending on command
   public void run()
   {

      boolean done = false;
      stdin = new Scanner(System.in);
      System.out.println("Enter members of teams that you want to add:");
      
      String name;
	  String date;
      
 
      while ( !done ) {
    	  String command = stdin.next();
    	
    	  switch (command){
    	  	case "A": name = stdin.next(); date = stdin.next(); add(name, date); break;
    	  	case "R": name = stdin.next(); date = stdin.next(); remove(name, date); break;
            case "P": print(); break;
            case "Q": done = true; break;
            default: System.out.println(String.format("command '%s' not supported!", command)); stdin.nextLine();//deal with bad command here
    	  }     
      }
   
   } 

   //Below functions adds team member to team
   private void add(String name, String date)
   {
	 
	   Date newDate = new Date(date);
	   
	   if(newDate.isValid()) {
		   TeamMember person = new TeamMember(name, newDate);
		   
		   if(!cs213.contains(person)) {
			   cs213.add(person);
			   System.out.println(String.format("%s has joined the team", person.toString()));
		   }
		   else {
			   System.out.println(person.toString() + " is already in team!");
		   }
	   }
	   else {
		   System.out.println(String.format("%s is not a valid date!", newDate.toString()));
	   }
  
   }

   //Below functions removes team members from team
   private void remove(String name, String date)
   {
	 
	   Date newDate = new Date(date);
	   
	   //If date is a valid date, remove team member
	   if (newDate.isValid()) {
		   cs213.remove(new TeamMember(name, newDate));
	   }
	   //else, date is not valid
	   else {
		   System.out.println(String.format("%s is not a valid date!", newDate.toString()));
	   }
	   
  
   }

   // Below function prints all team members in team
   private void print()
   {
	   cs213.print();  
   }

  
} //ProjectManager
