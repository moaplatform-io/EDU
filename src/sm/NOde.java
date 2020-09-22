package sm;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class NOde {
	public static void main(String[] args)throws Exception {
		//
		//필터 획득 과정
		InputStream is=fileinput();
		File ss=new File("abc");

		is=urlInput();
		byte[] buffer=new byte[1028];
		
		ByteArrayOutputStream arrayOutputStream=new ByteArrayOutputStream();
		int cnt=0;
		while((cnt=is.read(buffer))!=-1) {
			arrayOutputStream.write(buffer,0,cnt);
		}
		OutputStream os=fileout();
		os.write(arrayOutputStream.toByteArray());
		os.flush();
		
	}
	
	static public InputStream urlInput()throws Exception {
		URL url=new URL("https://m.dhlottery.co.kr/common.do?method=main");
		URLConnection  urlcon=url.openConnection();
		return urlcon.getInputStream();
	}

	
	static public OutputStream fileout()throws Exception {
		File file=new File("abc");
		FileOutputStream inputStream=new FileOutputStream(file);
		return inputStream;
	}
	
	static public InputStream fileinput()throws Exception {
		File file=new File("abc");
		FileInputStream inputStream=new FileInputStream(file);
		return inputStream;
	}
}
