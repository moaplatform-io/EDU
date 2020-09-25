package sg.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

public class SendThread extends Thread {
	
	private Socket socket;

	@Override
	public void run() {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			
			String send;
			while(true) {
				send = br.readLine();
				
				if (send.contains("end")) {
					break;
				}
				
				pw.println(send);
				pw.flush();
			}
			pw.close();
			br.close();
			socket.close();
		} catch(SocketException e) {
			System.out.println("소켓이 닫혔습니다.");
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	
}
