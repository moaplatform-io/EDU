package sg.socket;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

import sg.thread.ReceiveThread;
import sg.thread.SendThread;

public class SocketClinet {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost",8080);
			
			if (socket.isConnected()) {
				ReceiveThread rt = new ReceiveThread();
				rt.setSocket(socket);
				
				SendThread st = new SendThread();
				st.setSocket(socket);
				
				rt.start();
				st.start();	
			}
		} catch (SocketException e) {
			System.out.println("소켓이 닫혔습니다.");
			e.printStackTrace();
		} 
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
