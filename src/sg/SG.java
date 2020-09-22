package sg;

import java.util.Iterator;
import java.util.Set;

public class SG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("ehllo");
		
		Set<Integer> nu=LottoTest.makeLoto(args);

		Iterator<Integer> inter=nu.iterator();
		while(inter.hasNext()) {
			int n=inter.next();
			System.out.println(n);
		}
		
	}

}
