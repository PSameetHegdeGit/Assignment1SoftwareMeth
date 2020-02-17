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
      team = new TeamMember[GROW_SIZE];
   }

   //Below method finds a team member
   private int find(TeamMember m)
   {
	   int i = 0;
	   while (i < numMembers) {
		   if(m.toString().equals(team[i].toString())) {
			   return i;
		   }
		   i++;
	   }
       return -1;
   }

   
   //Below method increase size of array by the GROW_SIZE which is 4
   private void grow()
   {
	  
	  //If array is totally full --> create new array with 4 other elements & populate new team with this
      TeamMember [] newTeam = new TeamMember[sizeOfTeam(team) + 4];
      int size = sizeOfTeam(team);
      
      for(int i = 0; i < size; i++) {
    	  newTeam[i] = team[i];
      }
      team = newTeam;
   }

   
   //Below method returns true if array is empty
   public boolean isEmpty()
   {
	  
	   
	   int i = 0;
	   TeamMember emptyChecker;
	   
	   int size = sizeOfTeam(team);
	   
	   while (i < size) {
		   emptyChecker = team[i];
		   if (emptyChecker != null) {
			   return false;
		   }
		   i++;
	   }
	   numMembers = 0;
       return true;
   }

   
   //Below array adds Team Member to team
   public void add(TeamMember m)
   {

	   int i = 0;
	   try {
		   while(team[i] != null) {
			   i++;
		   }
		   team[i] = m;
		   numMembers++;
	   }
	   //If array is full 
	   catch(Exception e) {
		   grow();
		   add(m);
	   }
   }

   
   //Below array removes a team member from team and returns true; if team is empty, returns false
   public boolean remove(TeamMember m)
   {
	   if (isEmpty()) {
		   System.out.println("Team is empty!");
		   return false;
	   }
	   else {
		   int memberIndex = find(m);
		   if( memberIndex != -1) {
			   team[memberIndex] = team[numMembers-1];
			   team[numMembers-1] = null;
			   numMembers--;
			   
			   System.out.println(m.toString() + " has left the team.");
			   
			   return true;
		   }
	   }
	   System.out.println(m.toString() + " is not a team member.");
       return false;
   }

   
   //Below function returns true if team contains TeamMember m
   public boolean contains(TeamMember m)
   {

	   
	  if (isEmpty()) {
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
   
  
   //Below Function is a Helper Function: returns the size of team 
   private int sizeOfTeam(TeamMember[] team) {
	
	   
	   int size = 0;
	   TeamMember sizechecker;
	   try {
		   while (true) {
			   sizechecker = team[size];
			   size++;
		   }
	   }
	   catch(Exception e) { //Array out of bounds --> We get the size once we hit catch statement
		   
	   }
	   
	   return size;
   }

   
   public void print()
   {
	  System.out.println("We have the following Team Members:");
	  for(int i = 0; i < numMembers; i++) {
		  System.out.println(team[i].toString());
	  }
	  System.out.println("--End of List--");  
 
   }
}
