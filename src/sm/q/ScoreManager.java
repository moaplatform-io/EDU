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

public class ScoreManager {
	
	private StudendProcesor studendProcesor;
	
		
	public void doBuss(Bus bus) throws Exception{
		if(this.studendProcesor==null) {
			studendProcesor=init();
		}
		this.studendProcesor.process(bus);
	}
	
	public StudendProcesor init() throws Exception {
		
		FileInputStream fis=new FileInputStream("Config");
		Properties properties=new Properties();
		properties.load(fis);
		System.out.println("config:"+fis);
		
		

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
			
		StudendProcesor procesor=new StudendProcesor();
		
		procesor.setDataRear(dateReader);
		procesor.setParse(parse);
		procesor.setOuter(outer2);
		
		studendProcesor=procesor;
		return procesor;
		/**
		 *문제 풀이 
		 */
		
	}
	
}
