package sm.sockets;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.List;

public class SampleClient {
	/**
	 * 127.0.0.1
	 * localhost
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		Socket socket=new Socket("localhost",8087);
		boolean isT=socket.isConnected();
		System.out.println(isT);
		
		InputStream is=socket.getInputStream();
		OutputStream os=socket.getOutputStream();
		while(true) {
			SocetServerSample.writeSocket(os,"client:");
			SocetServerSample.readSocket(is);
		}
	}
}
