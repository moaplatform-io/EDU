package sm;

/**
 * 
 * @author 모아 혁신개발실
 *
 */
public class ExceptionSample {

	public static void main(String[] args) {
		ss();
		
	}
	
	
	static public void ss() {
		int a=-1;
		int c=3;
		int r=0;
		try {
			r = Sampless.stetme(a,c);
		} catch (ParameterNotMisnusNumber e) {
			e.printStackTrace();
			
		} catch (ParameterOverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(r);
	}
}
class Sampless {
	
	/**
	 * 
	 * @throws ParameterNotMisnusNumber 파라미터 - 올수 없습니다  
	 * @throws ParameterOverException  파라미터 100넘기면 메롱
	 */
	static public int stetme(int a,int b) throws ParameterNotMisnusNumber, ParameterOverException  {
		
		if(a<0) {
			throw new ParameterNotMisnusNumber(a);
		}	
		
		if(a>100) {
			throw new ParameterOverException();
		}
		return a+b;
	}
}
