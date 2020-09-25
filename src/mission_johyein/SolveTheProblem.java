package mission_johyein;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SolveTheProblem {
	
	//출력
	public static void main(String[] args) throws Exception {
		System.out.println("Q1) 1등의 이름 : " + question1());
		System.out.println("Q2) 10등의 출석번호 : " + question2or4(10));
		System.out.println("Q3) 전체평균 : " + question3());
		System.out.println("Q4) 77등의 출석번호 : " + question2or4(77));
		System.out.println("Q5) 국어성적 1위의 출석번호 : " + question5());
		System.out.println("Q6) 전체 성적 3퍼센트이하 : " + question6());
		System.out.println("Q7) 국어 성적순 정렬 실행 ............ \t" + question7or8("kor"));
		System.out.println("Q8) 수학 성적순 정렬 실행 ............ \t" + question7or8("math"));
	}
	
	public static ArrayList<String> question1() throws Exception {
		BufferedReader br = bufferedReader();
		/**
		 * 이름 ,합산 성적
		 */
		HashMap<String,Integer> map = nameScoreArray(br);
		ArrayList<Integer> scoreList = scoreList(map);
		Collections.sort(scoreList,new DescInt());
		
		ArrayList<String> keyArray = keyOfValue(map,scoreList.get(0));
		return keyArray;
	}
	
	public static ArrayList<String> question2or4(int grade) throws Exception {
		BufferedReader br = bufferedReader();
		HashMap<String,Integer> map = stuNumScoreArray(br);
		ArrayList<Integer> scoreList = scoreList(map);
		scoreList = distinct(scoreList);
		ArrayList<String> keyArray = keyOfValue(map, scoreList.get(grade-1));
		return keyArray;
	}
	
	public static double question3() throws Exception {
		BufferedReader br = bufferedReader();
		HashMap<String,Integer> map = nameScoreArray(br);
		ArrayList<Integer> scoreList = scoreList(map);
		int sum = sum(scoreList);
		return (double)sum/scoreList.size()/2;
	}
	
	public static ArrayList<String> question5() throws Exception {
		BufferedReader br = bufferedReader();
		HashMap<String,Integer> map = stuNumSubjectArray(br,"kor","stuNum");
		ArrayList<Integer> scoreList = scoreList(map);
		Collections.sort(scoreList,new DescInt());
		int korTop = scoreList.get(0);
		ArrayList<String> keyArray = keyOfValue(map, korTop);
		return keyArray;
	}
	
	public static ArrayList<String> question6() throws Exception{
		BufferedReader br = bufferedReader();
		HashMap<String,Integer> map = stuNumScoreArray(br);
		ArrayList<Integer> scoreList = scoreList(map);
		scoreList = distinct(scoreList);
		Collections.sort(scoreList,new DescInt());
		ArrayList<String> tpOfGrade = new ArrayList<String>();
		for(int i=0; i<=scoreList.size()*0.03; i++) {
				ArrayList<String> keyArr = keyOfValue(map, scoreList.get(i));
				for (int j = 0; j < keyArr.size(); j++) {
					tpOfGrade.add(keyArr.get(j));
				}
		}
		return tpOfGrade;
		
	}
	
	static public String question7or8(String subject) throws Exception {
		BufferedReader br = bufferedReader();
		int sub = 0;
		String fileName= null;
		
		if (subject.equals("kor")) {sub=3; fileName="국어성적순정렬";}
		else {sub=4; fileName="수학성적순정렬";}
		
		File file = new File(fileName);
		FileOutputStream out = new FileOutputStream(file);
		PrintWriter pw = new PrintWriter(out);
		
		Map<String, Integer> map = new HashMap<String,Integer>();
		
		String stuInfo = null;
		//map 에 stuInfo+korScore  put
		while((stuInfo = br.readLine())!=null) {
			try {				
			String[] splitTokens = stuInfo.split(",");
			int kor =Integer.parseInt(splitTokens[sub]);
			map.put(stuInfo, kor);
			} catch (ArrayIndexOutOfBoundsException e) {}
		}
		
		List<String> keyArr = new ArrayList<>(map.keySet());
		Collections.sort(keyArr, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));
		for(String key : keyArr) {
			pw.println(key);
		}
		pw.flush();
		pw.close();
		
		return "실행완료";
	}
	
	
	//읽어오기
	public static BufferedReader bufferedReader() throws Exception{
		File file = new File("stuInfo");
		FileInputStream in = new FileInputStream(file);
		InputStreamReader reader = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(reader);
		return br;
	}
	
	//Key반환
	public static ArrayList<String> keyOfValue(Map<String,Integer> map,int value) {
		ArrayList<String> arr = new ArrayList<String>();
		for(String key : map.keySet()) {
			if (value==map.get(key)) {
				arr.add(key);
			}
		}
		return arr;
	}
	
	//성적 합산 리스트
	public static ArrayList<Integer> scoreList(HashMap<String,Integer> map) throws Exception {
		ArrayList<Integer> scoreList = new ArrayList<Integer>(map.values());
		return scoreList;	
		
	}
	
	// 이름  +성적합산 리스트
	public static HashMap<String,Integer> nameScoreArray(BufferedReader br) throws Exception{
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		String stuInfo = null;
		while((stuInfo = br.readLine())!=null) {
			try {				
				String[] splitTokens = stuInfo.split(",");
				int sum =Integer.parseInt(splitTokens[3])+Integer.parseInt(splitTokens[4]);
				map.put(splitTokens[0], sum);
			} catch (ArrayIndexOutOfBoundsException e) {}
		}
		return map;
		
	}
	
	// 출석번호  +성적합산 리스트
	public static HashMap<String,Integer> stuNumScoreArray(BufferedReader br) throws Exception{
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		String stuInfo = null;
		while((stuInfo = br.readLine())!=null) {
			try {				
			String[] splitTokens = stuInfo.split(",");
			int sum =Integer.parseInt(splitTokens[3])+Integer.parseInt(splitTokens[4]);
			map.put(splitTokens[2], sum);
			} catch (ArrayIndexOutOfBoundsException e) {}
		}
		return map;
	}
	
	//출석번호or이름 +국어or수학성적 리스트
	public static HashMap<String,Integer> stuNumSubjectArray(BufferedReader br,String subject,String nameOrStuNum) throws Exception {
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		int sub = 0;
		int infoNum = 0;
		if (subject.equals("kor")) sub=3; else sub=4;
		if (nameOrStuNum.equals("stuNum")) infoNum=2; else infoNum=0;
		String stuInfo = null;
		while((stuInfo = br.readLine())!=null) {
			try {				
				String[] splitTokens = stuInfo.split(",");
				int kor =Integer.parseInt(splitTokens[sub]);
				map.put(splitTokens[infoNum], kor);
			} catch (ArrayIndexOutOfBoundsException e) {}
		}
		return map;
	}
	
	//전체 성적 총 합산
	public static int sum(ArrayList<Integer> scoreList) {
		int sum = 0;
		for (int i = 0; i < scoreList.size(); i++) {
			sum += scoreList.get(i);
		}
		return sum;
	}
	
	//성적 중복 제거
	public static ArrayList<Integer> distinct(ArrayList<Integer> array) {
		ArrayList<Integer> distinctArray = new ArrayList<Integer>();
		/*
		 * for (int i = 0; i < array.size(); i++) { if (!distinctArray.contains(array))
		 * { distinctArray.add(array.get(i)); } }
		 */
		distinctArray = (ArrayList<Integer>) array.parallelStream().distinct().collect(Collectors.toList());
		return distinctArray;
	}}

/**
 * 디센딩 한다 성적을 내림 차순으로하게 하는 기준
 * @author 모아 혁신개발실
 *
 */
class DescInt implements Comparator<Integer>{
	@Override
	public int compare(Integer o1, Integer o2) {
		return o2.compareTo(o1);
	}

}
