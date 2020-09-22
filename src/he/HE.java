package he;

import java.util.ArrayList;
import java.util.List;

public class HE {

	static public List<Integer>  makeLOto(String[] args) {
		ArrayList al = new ArrayList();

		int n = 0;

		while(al.size()==7) {
			n=makeLOto();
			if(!isDuplipcat(al, n)) {
				al.add(n);
			}
		}
		return al;
	}
	
	public static int makeLOto() {
		int n=0;
		n = (int) (Math.random() * 46 + 1);
		return n;
	}
		
	public static boolean isDuplipcat(List<Integer> list,int n) {
		boolean isDup=false;
		
		return isDup;
	}
	
	public static void main(String [] args) {
		System.out.println("go check");
		boolean isRoop=true;
		
		int cnt=0;
		do {
			List<Integer> lotos=makeLOto(args);
			
			if(lotos.size()<7) {
				System.out.println(cnt);
				System.out.println(lotos);
				break;
			}
			if((cnt++)%1000==0) {
				System.out.println("ok :"+cnt);
			}
		}while(isRoop);
		
		
	}

}
