package sm.q.impl.datarederimpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import mission_johyein.Student;
import sm.q.DateReader;
import sm.q.Parse;

public class ReaderFromFile implements DateReader{
	public String fileName;
	
	public ReaderFromFile(String fileName) {
		this.fileName=fileName;
	}
	
	@Override
	public List getStunt(Parse parse) throws Exception {
		List<Student> msg=new ArrayList<Student>();
		
		File file=new File(fileName);
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		String line=null;
		while((line=br.readLine())!=null) {
			Student stu=parse.parse(line);
			msg.add(stu);
		}
		return msg;
	}
}
