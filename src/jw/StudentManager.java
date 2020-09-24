package jw;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import sm.Studend;

/**
 * 학생 관련 manager class
 * 
 * @author jiwun
 *
 */
public class StudentManager {

	/**
	 * 학생 원본 리스트 반환
	 */
	public static List<StudentModel> getOrignalStudentList() {
		List<StudentModel> studentList = new ArrayList<StudentModel>();
		try {
			// 파일 경로
			String path = new File("repo").getAbsolutePath();
			Stream<String> stream = Files.lines(Paths.get(path));
			stream.collect(Collectors.toList()).forEach(student -> {
				// 학생 데이터 추가
				String[] sutentInfoArray = student.split(",");
				StudentModel studentModel = new StudentModel.Builder().setName(sutentInfoArray[0])
						.setAge(sutentInfoArray[1]).setAttendanceNumber(sutentInfoArray[2])
						.setKoreanLanguageGrade(sutentInfoArray[3]).setMathGrade(sutentInfoArray[4]).build();

				studentList.add(studentModel);
			});
			stream.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("학생 데이터 로드 실패");
			e.printStackTrace();
		}

		return studentList;
	}

	/**
	 * 국어 성적순으로 리스트 반환
	 */
	public static List<StudentModel> getStuentListSortKoreanLanguageGrade(List<StudentModel> studentModelList) {
		return studentModelList.stream().sorted(Comparator.comparing(StudentModel::getKoreanLanguageGrade).reversed())
				.collect(Collectors.toList());
	}

	/**
	 * 수학 성적순으로 리스트 반환
	 */
	public static List<StudentModel> getStuentListSortMathGrade(List<StudentModel> studentModelList) {
		return studentModelList.stream().sorted(Comparator.comparing(StudentModel::getMathGrade).reversed())
				.collect(Collectors.toList());
	}

	/**
	 * 국어 성적순으로 파일을 씀
	 */
	public static void writeStudentListSortKoreanLanguageGrade() {
		System.out.println("국어 성적순으로 파일을 쓰는중입니다.");
		File file = new File("KoreanLanguageGradeFile");
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(file);

			PrintWriter printWriter = new PrintWriter(fileOutputStream);
			// 원본 학생 리스트
			List<StudentModel> originalList = getOrignalStudentList();
			// 정렬된 학생 리스트
			List<StudentModel> sortList = getStuentListSortKoreanLanguageGrade(originalList);

			for (StudentModel studentModel : sortList) {
				String line = studentModel.getLine();
				printWriter.println(line);
			}
			printWriter.flush();
			printWriter.close();
			System.out.println("파일 쓰기 작업을 완료했습니다.");
			System.out.println("KoreanLanguageGradeFile 파일을 확인해 주세요.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("파일 쓰기 작업을 실패했습니다.");
		}
	}

	/**
	 * 수학 성적순으로 파일을 씀
	 */
	public static void writeStudentListSortMathGrade() {
		System.out.println("수학 성적순으로 파일을 쓰는중입니다.");
		File file = new File("MathGradeFile");
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(file);

			PrintWriter printWriter = new PrintWriter(fileOutputStream);
			// 원본 학생 리스트
			List<StudentModel> originalList = getOrignalStudentList();
			// 정렬된 학생 리스트
			List<StudentModel> sortList = getStuentListSortMathGrade(originalList);

			for (StudentModel studentModel : sortList) {
				String line = studentModel.getLine();
				printWriter.println(line);
			}
			printWriter.flush();
			printWriter.close();
			System.out.println("파일 쓰기 작업을 완료했습니다.");
			System.out.println("MathGradeFile 파일을 확인해 주세요.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("파일 쓰기 작업을 실패했습니다.");
		}
	}

	/**
	 * 학생 평균 세팅
	 */
	public static List<StudentModel> setStudentAvg() {
		List<StudentModel> list = getOrignalStudentList();
		for (StudentModel studentModel : list) {
			float avg = (studentModel.getKoreanLanguageGrade() + studentModel.getMathGrade()) / 2;
			studentModel.setAvg(avg);
		}
		return list;
	}

	/**
	 * 전체 평균 반환
	 */
	public static int getTotalAvg() {
		int sum = 0;
		List<StudentModel> studentModelList = setStudentAvg();
		for (StudentModel studentModel : studentModelList) {
			sum += studentModel.getAvg();
		}
		return sum / studentModelList.size();
	}

	/**
	 * 1등 평균 리스트 ( 중복 1등일 경우수가 있으므로 리스트 사용 )
	 */
	public static List<StudentModel> getFirstStudentList() {
		// 평균으로 정렬한 리스트
		List<StudentModel> studentAvgList = getStudentListSortAvg(setStudentAvg());

		// 1등 평균 리스트
		List<StudentModel> topClassList = new ArrayList<StudentModel>();

		for (StudentModel studentModel : studentAvgList) {
			if (topClassList.size() == 0) {
				// 1번 포지션은 무조건 1등
				topClassList.add(studentModel);
			} else {
				// 중복 1등 처리
				if (topClassList.get(0).getAvg() == studentModel.getAvg()) {
					// 1등과 평균이 같을경우 공동 1등으로 판단하고 리스트에 추가
					topClassList.add(studentModel);
				} else {
					// 해당 평균이 서로 다를경우 1등이 아니므로 반복문 중료
					break;
				}

			}
		}

		return topClassList;
	}

	/**
	 * 학생 리스트 평군 순으로 정렬
	 */
	public static List<StudentModel> getStudentListSortAvg(List<StudentModel> studentModelList) {
		return studentModelList.stream().sorted(Comparator.comparing(StudentModel::getAvg).reversed())
				.collect(Collectors.toList());
	}

	/**
	 * 국어 성적 1등 구하기
	 */
	public static List<StudentModel> getFirstKoreanLanguageList() {
		// 평균으로 정렬한 리스트
		List<StudentModel> studentList = getStuentListSortKoreanLanguageGrade(getOrignalStudentList());

		// 1등 평균 리스트
		List<StudentModel> topClassList = new ArrayList<StudentModel>();

		for (StudentModel studentModel : studentList) {
			if (topClassList.size() == 0) {
				// 1번 포지션은 무조건 1등
				topClassList.add(studentModel);
			} else {
				// 중복 1등 처리
				if (topClassList.get(0).getKoreanLanguageGrade() == studentModel.getKoreanLanguageGrade()) {
					// 1등과 평균이 같을경우 공동 1등으로 판단하고 리스트에 추가
					topClassList.add(studentModel);
				} else {
					// 해당 평균이 서로 다를경우 1등이 아니므로 반복문 중료
					break;
				}

			}
		}
		return topClassList;
	}

	/**
	 * 평균 점수 리스트
	 */
	public static Set<Float> getAvgList() {
		Set<Float> avgList = new HashSet<Float>();
		for (StudentModel studentModel : getStudentListSortAvg(setStudentAvg())) {
			avgList.add(studentModel.getAvg());
		}
		return avgList;
	}

	/**
	 * 평균 점수들중 n등수에 해당하는 평균 반환
	 */
	public static float getRankAvg(int rankNumber) {
		List<Float> rankList = new ArrayList<>(getAvgList());
		try {
			rankList.get(rankNumber);
			return rankList.get(rankNumber - 1);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("해당 랭킹번호를 구할수 없습니다.");
			return rankList.get(rankList.size() - 1);
		}
	}

	/**
	 * 틍정 랭킹에 해당하는 학생 리스트를 반환
	 */
	public static List<StudentModel> getRankList(int rankNumber) {
		// 평균값이 추가된 학생 리스트
		List<StudentModel> studentList = setStudentAvg();
		// 특정 랭킹의 학생 리스트
		List<StudentModel> targetRankingList = new ArrayList<StudentModel>();
		// 특정 랭킹의 평균
		float rankAvg = getRankAvg(rankNumber);

		for (StudentModel studentModel : studentList) {
			if (studentModel.getAvg() == rankAvg) {
				// 구하려는 랭킹의 평균점수와 일치하는 학생을 targetRankingList에 추가
				targetRankingList.add(studentModel);
			}
		}

		return targetRankingList;
	}

	/**
	 * 상위 n퍼센트 까지의 평균 점수 구하기
	 */
	public static float getRankPercentAvg(int topPercent) {
		List<Float> rankList = new ArrayList<>(getAvgList());
		float rankNumber = rankList.size() * topPercent / 100;
		return rankList.get((int) (Math.floor(rankNumber) - 1));
	}

	/**
	 * 상위 n퍼센트 학생 리스트
	 */
	public static List<StudentModel> getStudentModelList(int topPercent) {
		// 해당 퍼센트까지의 최대 평균 점수
		float maxAvg = getRankPercentAvg(topPercent);
		// n퍼센트까지의 학생리스트
		List<StudentModel> list = new ArrayList<StudentModel>();
		
		for (StudentModel studentModel : getStudentListSortAvg(setStudentAvg())) {
			if (studentModel.getAvg() >= maxAvg) {
				// 해당 학생 평균이 maxAvg 보다 크면 리스트에 추가
				list.add(studentModel);
			} else {
				// maxAvg 값보다 평균값이 작은 학생이 나오면 반복문 중지
				break;
			}
		}
		return list;
	}

}
