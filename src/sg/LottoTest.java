package sg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LottoTest {

	public static void main(String[] args) {
		Map<Integer,Integer> lottoMap = new HashMap<Integer, Integer>();
		Random random = new Random();
		
		while(lottoMap.size() < 7) {
			int num = random.nextInt(46);
			if(num != 0) {
				lottoMap.put(num, num);
			}
		}
		System.out.println("로또 당첨번호 : " + lottoMap.values());
	}

}
