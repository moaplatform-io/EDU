package sm.sockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * serversocket
 *
 * clietn socket
 */
public class SocetServerSample {

	static List<SocketAcepSocket> list = new ArrayList<SocketAcepSocket>();

	public static void main(String[] args) throws Exception{
		
		ServerSocket serverSocket=new ServerSocket(8087);
		
		System.out.println("waiting....");
		
		new Thread(
				new Runnable() {
					@Override
					public void run() {
						while(true) {
							try {
								writeSocket(list,"server:");
							} catch (IOException e) {
								e.printStackTrace();
							}
						}		
					}
				}
		).start();
		
		
		while(true) {
			Socket socket=serverSocket.accept();
			System.out.println("in:"+socket);
			SocketAcepSocket acepSocket=new SocketAcepSocket(socket);
			acepSocket.init();
			list.add(acepSocket);
		}
		
		
	}

	public static String readSocket(InputStream is) throws IOException {
		StringBuilder sb = new StringBuilder();
		int c = '\n';
		while ((c = is.read()) != '\n') {
			sb.append((char) c);
		}
		System.out.println(sb);
		return sb.toString();
	}

	public static void writeSocket(List<SocketAcepSocket> os, String prefix) throws IOException {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		for (int i = 0; i < os.size(); i++) {
			os.get(i).writeline(prefix + ":" + line);
		}
	}

	public static void writeSocket(OutputStream os, String prefix) throws IOException {
		Scanner scanner=new Scanner(System.in);
		String line=scanner.nextLine();
		os.write((prefix+line+"\n").getBytes());
		os.flush();
		
	}

}
