package he;

import java.util.ArrayList;

public class HE {

	public static void main(String[] args) {
		ArrayList al = new ArrayList();

		int n = 0;

		for (int i = 1; i <= 7; i++) {

			n = (int) (Math.random() * 46 + 1);

			for (int j = 0; j < al.size(); j++) {
				int n2 = (int) al.get(j);
				if (n == n2) {
					break;
				}
				al.add(n);
			}
			System.out.print(n + ", ");
		}
	}

}
