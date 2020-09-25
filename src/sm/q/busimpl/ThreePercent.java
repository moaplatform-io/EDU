package sm.q.busimpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import mission_johyein.Student;
import sm.q.Bus;
import sm.q.Outer;

public class ThreePercent implements Bus{

	@Override
	public void Process(List<Student> list, Outer outer) throws Exception {
		List<Student> retList=new ArrayList<Student>();
		Collections.sort(list
				,new Comparator<Student>() {
					@Override
					public int compare(Student o1, Student o2) {
						int ori=o1.getKorScore()+o1.getMathScore();
						int target=o2.getKorScore()+o2.getMathScore();
						return target-ori;
					}
				}
		);
		for (int i = 0; i < list.size()*0.03; i++) {
			retList.add(list.get(i));
		}
		
		outer.print(retList);
	}
}
