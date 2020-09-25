package sm.q;

import sm.q.busimpl.Hundress;
import sm.q.busimpl.ThreePercent;
import sm.q.busimpl.TotalAvg;

public class ScoreManagerTest {
	
	
	public static void main(String[] args)throws Exception {
		ScoreManager manager=new ScoreManager();
		
		Bus threee=new ThreePercent();
		Bus bus=new TotalAvg();
		Bus hund=new Hundress();

		
		manager.doBuss(bus);
	}
	
	
	
}
