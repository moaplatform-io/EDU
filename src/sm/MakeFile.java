package sm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MakeFile {
	static public OutputStream fileout()throws Exception {
		File file=new File("repo");
		FileOutputStream inputStream=new FileOutputStream(file);
		return inputStream;
	}
	public static void main(String[] args) throws Exception{
		OutputStream os=fileout();
		PrintWriter pw=new PrintWriter(os);
		
		for (int i = 0; i < 100000; i++) {
			String line=new Studend(nameMaker(), nameAge(), i+1, nameAge(),score()).getLine();
			pw.println(line);
		}
		pw.flush();
		pw.close();
	}
	public static int nameAge() {
		return new Random().nextInt(5)+10;
	}
	public static int score() {
		return new Random().nextInt(100)+0;
	}
	
	public static String nameMaker() {
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < 10; i++) {
			char c=(char) (new Random().nextInt(24)+97);
			sb.append(c);
		}
		
		return sb.toString();
	}
	

}
