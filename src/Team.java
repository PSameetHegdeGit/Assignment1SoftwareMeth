/**
This class defines a team and its operations
The methods are called when adding, removing, and printing team members
 @author Sameet Hegde, Abhijit Bhatt
 */
public class Team
{
   private final int NOT_FOUND = -1;
   private final int GROW_SIZE = 4; //initial and grow size
   private TeamMember [] team;
   private int numMembers;

   /**
   Constructor that initializes team array
   */
   public Team()
   {
      team = new TeamMember[GROW_SIZE];
   }

   /**
   Below method finds a team member
   @param member to be searched for in team
   @return index of member in the team array, -1 if not present
   */
   private int find(TeamMember member)
   {
	   int i = 0;
	   while (i < numMembers) {
		   if(member.toString().equals(team[i].toString())) {
			   return i;
		   }
		   i++;
	   }
       return -1;
   }

   
   /**
   Below method increase size of array by the GROW_SIZE which is 4
   */
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

   
   /**
   Below method returns true if array is empty
   @return true if empty, false otherwise
   */
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

   
   /**
   Below array adds Team Member to team
   @param member to be added to the team
   */
   public void add(TeamMember member)
   {

	   int i = 0;
	   try {
		   while(team[i] != null) {
			   i++;
		   }
		   team[i] = member;
		   numMembers++;
	   }
	   //If array is full 
	   catch(Exception e) {
		   grow();
		   add(member);
	   }
   }

   
   /**
   Below array removes a team member from team and returns true; if team is empty, returns false
   @param member to be removed from the team
   @return true if member was removed from team, false if member was not on team
   */
   public boolean remove(TeamMember member)
   {
	   if (isEmpty()) {
		   System.out.println("Team is empty!");
		   return false;
	   }
	   else {
		   int memberIndex = find(member);
		   if( memberIndex != -1) {
			   team[memberIndex] = team[numMembers-1];
			   team[numMembers-1] = null;
			   numMembers--;
			   
			   System.out.println(member.toString() + " has left the team.");
			   
			   return true;
		   }
	   }
	   System.out.println(member.toString() + " is not a team member.");
       return false;
   }

   
   /**
   Below function returns true if team contains TeamMember member
   @param member  to be compared with team array
   @return true if member is in team, false otherwise
   */
   public boolean contains(TeamMember member)
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
				  if(checker.equals(member)) {
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
   
  
   /**
   Below Function is a Helper Function: returns the size of team 
   @param team  the size of this array is found
   @return size of array
   */
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

   /**
   This method prints all members in the team
   */
   public void print()
   {
	  System.out.println("We have the following Team Members:");
	  for(int i = 0; i < numMembers; i++) {
		  System.out.println(team[i].toString());
	  }
	  System.out.println("--End of List--");  
 
   }
}
