import java.util.ArrayList;
import java.util.List;

import mission_johyein.Student;
import sm.q.Bus;
import sm.q.Outer;

public class ZeroList implements Bus {

	@Override
	public void Process(List<Student> arg0, Outer arg1) throws Exception {
		List<Student> st=new ArrayList<Student>();
		for (int i = 0; i < arg0.size(); i++) {
			if(arg0.get(i).getKorScore()==0 && arg0.get(i).getMathScore()==0) {
				st.add(arg0.get(i));
			}
		}
		arg1.print(st);
	}

}
