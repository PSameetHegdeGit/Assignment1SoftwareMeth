/**

 @author
 */
public class Team
{
   private final int NOT_FOUND = -1;
   private final int GROW_SIZE = 4; //initial and grow size
   private TeamMember [] team;
   private int numMembers;

   public Team()
   {
      //this is the default constructor
   }

   private int find(TeamMember m)
   {
       return 0;
   }

   private void grow()
   {
       
   }

   public boolean isEmpty()
   {
       return true;
   }

   public void add(TeamMember m)
   {

   }

   public boolean remove(TeamMember m)
   {
       return false;
   }

   public boolean contains(TeamMember m)
   {
	  if (!isEmpty()) {
		  return false;
	  }
	  else {
		  //Compare each team member in team w/ m
		  try {
			  int i = 0;
			  TeamMember checker = team[i];
			  while (true) {
				  if(checker.equals(m)) {
					  return true;
				  }
				  i++;
				  checker = team[i];
			  }
		  }
		  catch(Exception e) { //If Array index out of bounds
			  return false;
		  }
	  }
     
   }

   public void print()
   {
      //set up a for loop and call the toString() method
   }
}
