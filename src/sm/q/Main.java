package sm.q;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import sm.q.busimpl.Hundress;
import sm.q.busimpl.ThreePercent;
import sm.q.busimpl.TotalAvg;
import sm.q.impl.datarederimpl.DefaultParse;
import sm.q.impl.datarederimpl.ReaderFromFile;
import sm.q.impl.outerimpl.FileOut;
import sm.q.impl.outerimpl.ScreeOut;

public class Main {
	public static void main(String[] args) throws Exception {
		
		FileInputStream fis=new FileInputStream("Config");
		Properties properties=new Properties();
		properties.load(fis);
		System.out.println("config:"+fis);
		
		Bus threee=new ThreePercent();
		Bus bus=new TotalAvg();
		Bus hund=new Hundress();

		Outer outer2=(Outer) Class.forName(
					properties.getProperty("outer")
				).newInstance();
		outer2.setFileName(properties.getProperty("outer.fileName"));

		Parse parse=(Parse) Class.forName(
				properties.getProperty("Parse")
			).newInstance();
		DateReader dateReaderC=(DateReader) Class.forName(
				properties.getProperty("DateReader")
			).newInstance();
		
		
		dateReaderC.setFilename(properties.getProperty("DateReader.fileName"));
		
		DateReader dateReader=dateReaderC;
		
		
		Map<Integer,Outer> outer=new HashMap<Integer,Outer>();
		outer.put(FileOut.OuterMeter.File,new FileOut("HHHSS"));
		outer.put(FileOut.OuterMeter.Screen,new ScreeOut());
			
		String filename="repo";
	
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
