import java.util.*;

/**

 @author
 */

public class ProjectManager
{
   Scanner stdin;
   Team cs213;
   public void run()
   {

      boolean done = false;
      stdin = new Scanner(System.in);
      System.out.println("Enter members of teams that you want to add: \n");
      while ( !done )
      {
         String command = stdin.next();
         switch (command.charAt(0))
         {
            case 'A': add(); break;
            case 'R': remove(); break;
            case 'P': print(); break;
            case 'Q': quit(done); break;
            default: System.out.println("Mistyped command!!"); //deal with bad command here
         }
      }
      //write java code before you terminate the program
   } //run()

   private void add()
   {
      	//must check if the date is valid
	//must call the contains() method to check if a given
	//team member is in the team already
   }

   private void remove()
   {
      //must check if the date is valid

   }

   private void print()
   {
      //must check if the team has 0 members.
   }

   // This method was not included in template --> outputs all members and terminates the program
   private void quit(boolean done)
   {
      done = true;

   }
} //ProjectManager
