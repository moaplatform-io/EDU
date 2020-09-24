package jw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 시험 리스트 하면
 * 
 * @author jiwun
 *
 */
public class examListClass {

	public static void main(String[] args) {
		examOne();
		examTwo();
		examThree();
		examFour();
		examFive();
		examSix();
		examSeven();
		examEight();
	}
	
	/**
	 * 문제 1번
	 */
	private static void examOne() {
		System.out.println("-----------------------------------");
		System.out.println("문제 1 ) 1등의 이름은 무엇인가? ");
		System.out.println("전체 1등수 : " + StudentManager.getFirstStudentList().size());
		System.out.println("전체 평균 : ");
		for(StudentModel studentModel : StudentManager.getFirstStudentList()) {
			System.out.println(studentModel.getName());	
		}
		System.out.println("-----------------------------------");
	}
	
	/**
	 * 문제 2번
	 */
	private static void examTwo() {
		System.out.println("-----------------------------------");
		System.out.println("문제 2 ) 10등의 출석 번호는??");
		List<StudentModel> studentModelList = StudentManager.getRankList(10);
		System.out.println("10등 학생 수 : " + studentModelList.size());
		for(StudentModel studentModel : studentModelList) {
			System.out.println(studentModel.getAttendanceNumber());	
		}
		System.out.println("-----------------------------------");
	}
	
	/**
	 * 문제 3번
	 */
	private static void examThree() {
		System.out.println("-----------------------------------");
		System.out.println("문제 3 ) 전체 평균은? ");
		System.out.println("전체 평균 : " + StudentManager.getTotalAvg());
		System.out.println("-----------------------------------");
	}
	
	/**
	 * 문제 2번
	 */
	private static void examFour() {
		System.out.println("-----------------------------------");
		System.out.println("문제 4 ) .77등의 출석번호는?");
		List<StudentModel> studentModelList = StudentManager.getRankList(77);
		System.out.println("77등 학생 수 : " + studentModelList.size());
		for(StudentModel studentModel : studentModelList) {
			System.out.println(studentModel.getAttendanceNumber());	
		}
		System.out.println("-----------------------------------");
	}

	/**
	 * 문제 5번
	 */
	private static void examFive() {
		System.out.println("-----------------------------------");
		System.out.println("문제 5 ) 국어 성적 1위의 출석 번호는? ");
		System.out.println("국어 성정 1등 학생수 : " + StudentManager.getFirstKoreanLanguageList().size());
		System.out.println("국어 성적 1등 출석 번호 : ");
		for(StudentModel studentModel : StudentManager.getFirstStudentList()) {
			System.out.println(studentModel.getAttendanceNumber());	
		}
		System.out.println("-----------------------------------");
	}
	
	/**
	 * 문제 6번
	 */
	private static void examSix() {
		System.out.println("-----------------------------------");
		System.out.println("문제 6 ) 전체 성적 3퍼센트 안에 해당 하는 출석 번호 리스트를 뽑으시오 ");
		System.out.println("상위 3퍼센트 학생수 : " + StudentManager.getStudentModelList(3).size());
		System.out.println("상위 3퍼센트 학생 출석번호 : ");
		for(StudentModel studentModel : StudentManager.getStudentModelList(3)) {
			System.out.println(studentModel.getAttendanceNumber());	
		}
		System.out.println("-----------------------------------");
	}

	
	/**
	 * 문제 7번
	 */
	private static void examSeven() {
		System.out.println("-----------------------------------");
		System.out.println("문제 7 ) 국어성적 순으로정렬 하여 file 출력 하시오 ");
		StudentManager.writeStudentListSortKoreanLanguageGrade();
		System.out.println("-----------------------------------");
	}

	/**
	 * 문제 8번
	 */
	private static void examEight() {
		System.out.println("-----------------------------------");
		System.out.println("문제 8 ) 수학성적 순으로 정렬 하여 file 출력 하시오 ");
		StudentManager.writeStudentListSortMathGrade();
		System.out.println("-----------------------------------");
	}

}
