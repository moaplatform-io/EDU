package sm.sockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketAcepSocket {
	
	InputStream is;
	OutputStream os;
	public SocketAcepSocket(Socket socket) throws IOException{
		 is=socket.getInputStream();
		 os=socket.getOutputStream();
	}
	public void init() {
		ReadThread readThread=new ReadThread();
		readThread.is=is;
		readThread.start();
	}
	public void writeline(String string) throws IOException {
		os.write((string+"\n").getBytes());
	}
	
}
