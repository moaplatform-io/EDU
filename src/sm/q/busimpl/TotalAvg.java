package sm.q.busimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mission_johyein.Student;
import sm.q.Bus;
import sm.q.Outer;
import sm.q.impl.outerimpl.FileOut;

public class TotalAvg implements Bus{

	@Override
	public void Process(List<Student> list, Outer outer) throws Exception {
		int sum=0;
		for (int i = 0; i < list.size(); i++) {
			sum+=list.get(i).getKorScore()+list.get(i).getMathScore();
		}
		sum/=list.size();
		sum/=2;
		
		List<String> out=new ArrayList<String>();
		out.add(sum+"");
		
		outer.print(out);
	}
}
