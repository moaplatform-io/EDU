package sm.sockets.threadsm;

public class ThreadSam extends Thread{
	@Override
	public void run() {
		try {
			int c=1;
			while(true) {
				System.out.println("근본이 있는 스레드.:"+c);
				Thread.sleep(1000);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
