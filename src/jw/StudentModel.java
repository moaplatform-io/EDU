package jw;

/**
 * 학생 모델 class
 * 
 * @author jiwun
 *
 */
public class StudentModel {

	// 이름
	private String name;
	// 나이
	private int age;
	// 출석 번호
	private int attendanceNumber;
	// 국어 성적
	private int koreanLanguageGrade;
	// 수학 성적
	private int mathGrade;
	// 평균
	private float avg = 0;

	public static class Builder {
		private String name;
		private int age;
		private int attendanceNumber;
		private int koreanLanguageGrade;
		private int mathGrade;

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setAge(String age) {
			try {
				this.age = Integer.parseInt(age);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				System.out.println("나이 숫자로 변환 실패 : " + age);
				this.age = 0;
			}
			return this;
		}

		public Builder setAttendanceNumber(String attendanceNumber) {
			try {
				this.attendanceNumber = Integer.parseInt(attendanceNumber);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				System.out.println("출석번호 숫자로 변환 실패: " + attendanceNumber);
				this.attendanceNumber = 0;
			}
			return this;
		}

		public Builder setKoreanLanguageGrade(String koreanLanguageGrade) {
			try {
				this.koreanLanguageGrade = Integer.parseInt(koreanLanguageGrade);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				System.out.println("국어 성적 숫자로 변환 실패 : " + koreanLanguageGrade);
				this.koreanLanguageGrade = 0;
			}
			return this;
		}

		public Builder setMathGrade(String mathGrade) {
			try {
				this.mathGrade = Integer.parseInt(mathGrade);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				System.out.println("수학 성적 숫자로 변환 실패 : " + mathGrade);
				this.mathGrade = 0;
			}
			return this;
		}

		public StudentModel build() {
			return new StudentModel(this);
		}

	}

	private StudentModel(Builder builder) {
		this.name = builder.name;
		this.age = builder.age;
		this.attendanceNumber = builder.attendanceNumber;
		this.koreanLanguageGrade = builder.koreanLanguageGrade;
		this.mathGrade = builder.mathGrade;
	}

	public int getAge() {
		return age;
	}

	public int getAttendanceNumber() {
		return attendanceNumber;
	}

	public int getKoreanLanguageGrade() {
		return koreanLanguageGrade;
	}

	public int getMathGrade() {
		return mathGrade;
	}

	public String getName() {
		return name;
	}
	
	public void setAvg(float avg) {
		this.avg = avg;
	}
	
	public float getAvg() {
		return avg;
	}

	/**
	 * 파일 읽기 시 사용할 
	 * @return
	 */
	public String getLine() {

		StringBuilder sb = new StringBuilder();
		return sb.append(name)
				.append(",")
				.append(age)
				.append(",")
				.append(attendanceNumber)
				.append(",")
				.append(koreanLanguageGrade)
				.append(",")
				.append(mathGrade)
				.toString();
	}
}
