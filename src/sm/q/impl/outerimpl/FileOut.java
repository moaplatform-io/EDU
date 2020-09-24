package sm.q.impl.outerimpl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

import sm.q.Outer;

public class FileOut implements Outer{
	
	public  FileOut () {
		
	}
	public FileOut(String name) {
		this.name=name;
	}

	public String name;
	@Override
	public void print(List obj)throws Exception {
		File file=new File(name);
		FileOutputStream fos=new FileOutputStream(file);
		PrintWriter pw=new PrintWriter(fos);
		for (int i = 0; i < obj.size(); i++) {
			pw.println(obj.get(i));
		}
		pw.flush();
		pw.close();
	}
	@Override
	public void setFileName(String filename) throws Exception {
		this.name=filename;
	}

}
