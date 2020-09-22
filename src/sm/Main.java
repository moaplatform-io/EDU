package sm;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Main {

	
	public static List<String> list;
	
	public static void main(String[] args) throws InterruptedException {
		int i=0;
		while(i++<10){
			try {
//				list=new ArrayList<String>();
//				list=new Vector<String>();
				addAAA();
				addBBB();
				
				Thread thread=new Thread(addAAA());
				Thread thread2=new Thread(addBBB());
				
		//		thread.join();
		//		thread2.join();
				thread.start();
				thread2.start();
				thread.join();
				thread2.join();
				System.out.println("size:"+list.size());
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Runnable addAAA() {
		Runnable aaRun=new Runnable() {
			@Override
			public void run() {
				int count=1;
				while(count++<=1000) {
					list.add("bbb");
				}
				
			}
		};
		return aaRun;
	}
	public static Runnable addBBB() {
		Runnable aaRun=new Runnable() {
			@Override
			public void run() {
				int count=1;
				while(count++<=1000) {
					list.add("aaaa");
				}
				
			}
		};
		return aaRun;
	}
}
