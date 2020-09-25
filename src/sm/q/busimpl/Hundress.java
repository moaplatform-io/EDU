package sm.q.busimpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import mission_johyein.Student;
import sm.q.Bus;
import sm.q.Outer;

/**
 * 100점 사람 뽑기 
 * @author 모아 혁신개발실
 *
 */
public class Hundress implements Bus{

	@Override
	public void Process(List<Student> list, Outer outer) throws Exception {
		List<Student> retList=new ArrayList<Student>();
		
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getKorScore()==100
					&& list.get(i).getMathScore()==100
					)
				retList.add(list.get(i));
		}
		outer.print(retList);
	}
}
