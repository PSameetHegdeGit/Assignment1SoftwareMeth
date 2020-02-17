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

   private void grow()
   {
	   System.out.println("in grow: team Class");
	  //If array is totally full --> create new array with 4 other elements & populate new team with this
      TeamMember [] newTeam = new TeamMember[sizeOfTeam(team) + 4];
      int size = sizeOfTeam(team);
      
      for(int i = 0; i < size; i++) {
    	  newTeam[i] = team[i];
      }
      team = newTeam;
   }

   public boolean isEmpty()
   {
	   System.out.println("In IsEmpty: Team Class");
	   
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

   //Does not look for duplicates
   public void add(TeamMember m)
   {
	   System.out.println("In add function: team class");
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
	   System.out.println(team[i].toString());
   }

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
			   return true;
		   }
		   /*int i = 0;
		   while (i < numMembers) {
			   if(m.toString().equals(team[i].toString())) {
				   team[i] = team[numMembers-1];
				   team[numMembers-1] = null;
				   numMembers--;
				   return true;
			   }
			   i++;
		   }*/
	   }
	   System.out.println("Team member does not exist!");
       return false;
   }

   public boolean contains(TeamMember m)
   {
	  System.out.println("In Contains: team class"); 
	   
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
   
   //Get method for the team
   public TeamMember[] getTeam(TeamMember [] team) {
	   return team;
   }
   
   //Returns the sizez of the team
   private int sizeOfTeam(TeamMember[] team) {
	   System.out.println("In sizeOfTeam: team class");
	   
	   int size = 0;
	   TeamMember sizechecker;
	   try {
		   while (true) {
			   sizechecker = team[size];
			   size++;
		   }
	   }
	   catch(Exception e) { //Array out of bounds --> gives us size once we hit catch statement
		   
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
      //set up a for loop and call the toString() method
   }
}
