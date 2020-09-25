package sg.thread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceiveThread extends Thread {
	
	private Socket socket;

	@Override
	public void run() {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			String receive;
			
			while(true) {
				receive = br.readLine();
				if (receive !=null) {
					System.out.println("메시지가 도착했습니다 : " + receive);	
				}
			}
			
		} catch(Exception e) {
			System.out.println("소켓이 닫혔습니다.");
			e.printStackTrace();
		}
	}
	
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	
}
