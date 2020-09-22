package sg;

public class StudentDto {
    private String name;
    private int age;
    private int attendanceNumber;
    private int korScore;
    private int mathScore;

    public StudentDto(String name, int age, int attendanceNumber, int korScore, int mathScore) {
        this.name = name;
        this.age = age;
        this.attendanceNumber = attendanceNumber;
        this.korScore = korScore;
        this.mathScore = mathScore;
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

    public int getAttendanceNumber() {
        return attendanceNumber;
    }

    public void setAttendanceNumber(int attendanceNumber) {
        this.attendanceNumber = attendanceNumber;
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

    @java.lang.Override
    public java.lang.String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name)
                .append(",")
                .append(age)
                .append(",")
                .append(attendanceNumber)
                .append(",")
                .append(korScore)
                .append(",")
                .append(mathScore);
        return sb.toString();
    }
}