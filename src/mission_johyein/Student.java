package mission_johyein;

public class Student {
	private String name;
	private int age;
	private int stuNum;
	private int korScore;
	private int mathScore;
	
	public Student(String name,int age,int stuNum,int korScore,int mathScore) {
		this.name=name;
		this.age=age;
		this.stuNum=stuNum;
		this.korScore=korScore;
		this.mathScore=mathScore;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public int getStuNum() {
		return stuNum;
	}
	public void setStuNum(int stuNum) {
		this.stuNum = stuNum;
	}
	public int getKorScore() {
		return korScore;
	}
	public void setKorScore(int korScore) {
		this.korScore = korScore;
	}
	public int getMathScore() {
		return mathScore;
	}
	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}
	
	public String getLine() {
		
		StringBuilder sb=new StringBuilder();
			sb.append(name)
			.append(",")
			.append(age)
			.append(",")
			.append(stuNum)
			.append(",")
			.append(korScore)
			.append(",")
			.append(mathScore);
			
		return sb.toString();
	}
	
	
}
