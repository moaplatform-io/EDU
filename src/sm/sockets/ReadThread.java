package sm.sockets;

import java.io.IOException;
import java.io.InputStream;

public class ReadThread extends Thread{
	
	public InputStream is;
	
	@Override
	public void run() {
		try {
			while(true) {
				SocetServerSample.readSocket(is);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
