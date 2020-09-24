package sg;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class LottoTest {

	public static Set<Integer> makeLoto(String[] args) {
		
//		TreeSet<Integer> cars = new TreeSet<Integer>();
		HashSet<Integer> cars = new HashSet<Integer>();
		
		Random random = new Random();
		while(cars.size() < 7) {
			int num = random.nextInt(45)+1;
			cars.add(num);
		}
		System.out.println("로또 당첨번호 : " +cars);
//		cars.equals(o);

		
		return cars;
	}
	
	

}
