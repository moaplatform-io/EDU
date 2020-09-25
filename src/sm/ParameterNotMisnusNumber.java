package sm;

public class ParameterNotMisnusNumber extends Exception{
	
	public ParameterNotMisnusNumber(int a) {
		super("minus 는 허용되지 않습니다 . 입력된 값은 :"+a);
	}

}
