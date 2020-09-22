package sg;
import java.util.HashSet;
import java.util.Random;

public class LottoTest {

	public static void main(String[] args) {
		
		HashSet<Integer> cars = new HashSet<Integer>();
		Random random = new Random();
		while(cars.size() < 7) {
			int num = random.nextInt(45)+1;
			cars.add(num);
		}
		System.out.println("로또 당첨번호 : " +cars);
	}

}
