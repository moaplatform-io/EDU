package sm.sockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
/**
 *serversocket
 *
 * clietn socket
 */
public class SocetServerSample {

	public static void main(String[] args) throws Exception{
		
		ServerSocket serverSocket=new ServerSocket(8087);
		System.out.println("waiting....");
		Socket socket=serverSocket.accept();
		System.out.println("in:"+socket);
		InputStream is=socket.getInputStream();
		OutputStream os=socket.getOutputStream();
		
		System.out.println("in:"+is);
		System.out.println("os:"+os);
		
		boolean isROop=true;
		while(isROop) {
			String msg=readSocket(is);
			if(msg.indexOf("end")>=0) {
				isROop=false;
				return;
			}
			writeSocket(os,"server:");
		}
		
	}
	public static String readSocket(InputStream is) throws IOException {
		StringBuilder sb=new StringBuilder();
		int c='\n';
		while((c= is.read())!='\n') {
			sb.append((char)c);
		}
		System.out.println(sb);
		return sb.toString();
	}
	public static void writeSocket(OutputStream os,String prefix) throws IOException {
		Scanner scanner=new Scanner(System.in);
		String line=scanner.nextLine();
		os.write((prefix+line+"\n").getBytes());
		os.flush();
	}

}
