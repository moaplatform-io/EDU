package sm;

public class RuntimeExceptionSample2 {

	public static void main(String[] args) {
		ss();
	}
	static public void ss() {
		int a=101;
		int c=3;
		int r=0;
		r = Samplesses.stetme(a,c);
		System.out.println(r);
	}
}
class Samplesses {
	
	/**
	 * 
	 * @throws ParameterNotMisnusNumber 파라미터 - 올수 없습니다  
	 * @throws ParameterOverException  파라미터 100넘기면 메롱
	 */
	static public int stetme(int a,int b) {
		
		if(a<0) {
			throw new RuntimeException();
		}	
		
		if(a>100) {
			throw new RuntimeException();
		}
		return a+b;
	}
}
