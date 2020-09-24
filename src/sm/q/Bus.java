package sm.q;

import java.util.List;
import java.util.Map;

import mission_johyein.Student;

public interface Bus {

	void Process(List<Student> list, Outer outer)throws Exception;
	
}
