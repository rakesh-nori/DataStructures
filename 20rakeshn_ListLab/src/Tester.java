import java.util.*;
public class Tester 
{
	public static void main (String [] args)
	{
		ArrayList<String> members = new ArrayList<String>();
		String [] mem = {"Sumantro", "Ronit", "Allison", "Anna", "Rakesh", "Carolyn", "Jackie"};
		for (int i = 0; i < 7; i++)
		{
				members.add(mem[i]);
		}
		
		Corporation c = new Corporation(mem[0], members, 20920334);
		c.goPublic();
		c.addWorth(239408);
		c.meetForCollaboration(950);
		c.meetForDiscussion(1050);
		SoccerTeam s = new SoccerTeam(mem[0], members);
		s.playSport();
		s.meetForCollaboration(1200);
		s.meetForDiscission(1215);
		s.addMember("Mrs. Datar");
		Construction con = new Construction(mem[0], members);
		{
			con.getMember(4);
			con.setLeader("Ranit the Bandit");
			con.removeMember(5);
		}
		
				
		
	}
}
