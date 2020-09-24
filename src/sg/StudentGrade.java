package sg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class StudentGrade {
	
	private static List<StudentDto> studentList;
	
	public static OutputStream inputStream() throws Exception {
		File file = new File("sg");
		FileOutputStream inputStream = new FileOutputStream(file);
		return inputStream;
	}

	public static void main(String[] args) throws Exception {

		
		studentList = addList();
		System.out.println(answer());
	}

	public static int nameAge() {
		return new Random().nextInt(5) + 10;
	}

	public static int score() {
		return new Random().nextInt(101);
	}

	public static String nameMaker() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			char c = (char) (new Random().nextInt(24) + 97);
			sb.append(c);
		}
		return sb.toString();
	}
	
	private static List<StudentDto> addList() throws Exception {
		List<StudentDto> studentList = new ArrayList<StudentDto>();
		BufferedReader br = new BufferedReader(new FileReader(new File("./src/sg/sg")));
		StudentDto student;
		String line;
		while((line = br.readLine()) != null) {
			String[] lineArray = line.split(",");
			student = new StudentDto(
					lineArray[0],
					parseInt(lineArray[1]),
					parseInt(lineArray[2]),
					parseInt(lineArray[3]),
					parseInt(lineArray[4]));
			studentList.add(student);
		}
		br.close();
		
		return studentList;
	}
	
//	private static String quiz1() throws Exception {
//		List<String> studentName = new ArrayList<String>();
//		List<StudentDto> list = studentList;
//		
//	
//		System.out.println(list.toString());
//		
//		for(int i=0; i < list.size(); i++) {
//			String name = studentList.get(i).getName();
//			studentName.add(name);
//		}
//		
//		return studentName.toString();
//	}
	
//	private static String quiz2() throws Exception {
//		List<Integer> scoreList = reverseSumScoreList();
//		List<Integer> studentNumber = new ArrayList<Integer>();
//		scoreList = scoreList.subList(scoreList.indexOf());
//		
//		for(int i=0; i < scoreList.size(); i++) {
//			String name = studentList.get(i).getName();
//			studentNumber.add(name);
//		}
//		return null;
//	}
	
	private static String quiz3() throws Exception {
		int korScore = 0, mathScore = 0;
		for (int i = 0; i < studentList.size(); i++) {
			korScore += studentList.get(i).getKorScore();
			mathScore += studentList.get(i).getMathScore();
		}
		korScore = (int) korScore / studentList.size();
		mathScore = (int) mathScore / studentList.size();
		
		return new StringBuilder()
				.append("국어 : ")
				.append(korScore)
				.append("점, ")
				.append("수학 : ")
				.append(mathScore)
				.append("점")
				.toString();
	}
	
	private static String quiz5() throws Exception {
		
		return null;
	}
	
	private static String quiz6() throws Exception {
		int highRank = (int) (studentList.size() * 0.03);
		List<StudentDto> highRankList = new ArrayList<StudentDto>();
		for(int i = 0; i < highRank; i++) {
			highRankList.add(studentList.get(i));
		}
		return highRankList.toString();
	}
	
	private static String quiz7() throws Exception {
		String fileName = "sg_kor_sort";
		List<StudentDto> list = studentList;
		Collections.sort(list, new Comparator<StudentDto>() {
			@Override
			public int compare(StudentDto o1, StudentDto o2) {
				// TODO Auto-generated method stub
				return o2.getKorScore() - o1.getKorScore();
			}
			
		});
		writeFile(fileName, list);
		return new StringBuilder()
				.append("파일 이름 : ")
				.append(fileName)
				.toString();
	}
	
	private static String quiz8() throws Exception {
		String fileName = "sg_math_sort";
		List<StudentDto> list = studentList;
		
		Collections.sort(list, new Comparator<StudentDto>() {
			@Override
			public int compare(StudentDto o1, StudentDto o2) {
				// TODO Auto-generated method stub
				return o2.getMathScore() - o1.getMathScore();
			}
		});
		writeFile(fileName,list);		
		return new StringBuilder()
				.append("파일 이름 : ")
				.append(fileName)
				.toString();
	}
	
	public static String answer() throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("1. 1등의 이름은 무엇인가? : ")
//		  .append(quiz1())
		  .append("\n")
		  .append("2. 10등의 출석 번호는?? : ")
		  .append("\n")
		  .append("3. 전체 평균은? : ")
		  .append(quiz3())
		  .append("\n")
		  .append("4. 77등의 출석번호는? : ")
		  .append("\n")
		  .append("5. 국어 성적 1위의 출석 번호는? : ")
		  .append(quiz5())
		  .append("\n")
		  .append("6. 전체 성적 3퍼센트 안에 해당 하는 출석 번호 리스트를 뽑으시오 : ")
		  .append(quiz6())
		  .append("\n")
		  .append("7. 국어성적 순으로정렬 하여 file 출력 하시오  : ")
		  .append(quiz7())
		  .append("\n")
		  .append("8. 수학성적 순으로 정렬 하여 file 출력 하시오 : ")
		  .append(quiz8());
		return sb.toString();
	}
	
//	private static int add(int a1,int a2) {
//		return a1+a2;
//	}
	
	private static int parseInt(String s) {
		return Integer.parseInt(s);	
	}
	
	private static void writeFile(String fileName, List<StudentDto> list) throws Exception {
		File file = new File("./src/sg/" + fileName);
		FileOutputStream inputStream = new FileOutputStream(file);
		OutputStream os = inputStream;
		PrintWriter pw = new PrintWriter(os);

		for (int i = 0; i < list.size(); i++) {
			String line = list.get(i).toString();
			pw.println(line);
		}
		pw.flush();
		pw.close();
	}

}