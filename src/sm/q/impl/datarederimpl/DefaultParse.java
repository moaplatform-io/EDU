package sm.q.impl.datarederimpl;

import mission_johyein.Student;
import sm.q.Parse;

public class DefaultParse implements Parse{

	@Override
	public Student parse(String line) {
		String lienes[]=line.split(",");
		String name=lienes[0];
		int age=Integer.parseInt(lienes[1]);
		int stuNum=Integer.parseInt(lienes[2]);
		int korScore=Integer.parseInt(lienes[3]);
		int mathScore=Integer.parseInt(lienes[4]);
		Student student=new Student(name, age, stuNum, korScore, mathScore);
		return student;
	}

}
