package sm.sockets.threadsm;

public class ThreadSample {
	public static void main(String[] args)throws Exception{
		
		ThreadSam sam=new ThreadSam();
		sam.run();
		
		while(true) {
			System.out.println("\t근본이 있을까?");
			Thread.sleep(1000);
		}
		
	}
}
