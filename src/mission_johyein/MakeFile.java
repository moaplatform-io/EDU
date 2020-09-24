package mission_johyein;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MakeFile {
	static public OutputStream fileout() throws Exception {
		File file = new File("stuInfo");
		FileOutputStream out = new FileOutputStream(file);
		return out;
	}

	public static void main(String[] args) throws Exception {
		OutputStream out = fileout();
		PrintWriter pw = new PrintWriter(out);

		for (int i = 0; i < 100000; i++) {
			String line = new Student(nameMaker(), makeAge(), i + 1, makeKorScore(), makeMathScore()).getLine();
			pw.println(line);
		}
		pw.flush();
		pw.close();
	}

	public static int makeAge() {
		return new Random().nextInt(3) + 17;
	}

	public static int makeKorScore() {
		return new Random().nextInt(101) + 0;
	}

	public static int makeMathScore() {
		return new Random().nextInt(101) + 0;
	}

	public static String nameMaker() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			/*
			 * char c = (char) (new Random().nextInt(24) + 97); sb.append(c);
			 */
			char name = (char)(new Random().nextInt(26)+97);
			sb.append(name);
		}

		return sb.toString();
	}

}
