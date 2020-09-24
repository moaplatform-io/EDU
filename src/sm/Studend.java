package sm;

public class Studend {
	private String name;
	private int age;
	private int  출석번호;
	private int korScore;
	private int mathScore;
	
	public Studend(String name,int age,int 출석번호,int korScore,int mathScore) {
		this.name=name;
		this.age=age;
		this.출석번호=출석번호;
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

	public int get출석번호() {
		return 출석번호;
	}
	public void set출석번호(int 출석번호) {
		this.출석번호 = 출석번호;
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
		
		// TODO age가 빠져있어서 추가
		StringBuilder sb=new StringBuilder();
			sb.append(name)
			.append(",")
			.append(age)
			.append(",")
			.append(출석번호)
			.append(",")
			.append(korScore)
			.append(",")
			.append(mathScore);
			
		return sb.toString();
	}
	
	
}
