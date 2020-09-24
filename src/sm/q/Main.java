package sm.q;

import java.util.HashMap;
import java.util.Map;

import sm.q.busimpl.Hundress;
import sm.q.busimpl.ThreePercent;
import sm.q.busimpl.TotalAvg;
import sm.q.impl.datarederimpl.DefaultParse;
import sm.q.impl.datarederimpl.ReaderFromFile;
import sm.q.impl.outerimpl.FileOut;
import sm.q.impl.outerimpl.ScreeOut;

public class Main {


	public static void main(String[] args) throws Exception {

		Bus threee=new ThreePercent();
		Bus bus=new TotalAvg();
		Bus hund=new Hundress();

		Outer outer2=new ScreeOut();
		
		Map<Integer,Outer> outer=new HashMap<Integer,Outer>();
		outer.put(FileOut.OuterMeter.File,new FileOut("HHHSS"));
		outer.put(FileOut.OuterMeter.Screen,new ScreeOut());
			
		String filename="repo";
		Parse parse=new DefaultParse();
		ReaderFromFile file=new ReaderFromFile(filename);
		DateReader dateReader=file;
	
		StudendProcesor procesor=new StudendProcesor();
		procesor.setDataRear(dateReader);
		procesor.setOuter(outer);
		procesor.setParse(parse);
		
		/**
		 *문제 풀이 
		 */
		
		procesor.process(new sm.q.busimpl.Hundress(),outer2);
		procesor.process(threee,outer2);
		procesor.process(hund,outer2);
		
	}
	
}
