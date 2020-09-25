package sm.q;

import java.util.List;
import java.util.Map;

import mission_johyein.Student;

public class StudendProcesor {
	private Parse parse;
	private DateReader dataRear;
	private List<Student> list;
	private Outer outer;
	
	public void setOuter(Outer outer) {
		this.outer = outer;
	}

	/**
	 * 
	 * @param bus
	 * @param outer
	 * @throws Exception
	 */
	public void process(Bus bus) throws Exception {
		if(list==null){
			list=dataRear.getStunt(parse);
		}
		bus.Process(list,outer);
	}
	
	public Parse getParse() {
		return parse;
	}

	public void setParse(Parse parse) {
		this.parse = parse;
	}

	public DateReader getDataRear() {
		return dataRear;
	}

	public void setDataRear(DateReader dataRear) {
		this.dataRear = dataRear;
	}


}
