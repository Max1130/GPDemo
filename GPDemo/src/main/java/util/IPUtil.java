package util;

import java.net.InetAddress;


public class IPUtil {
	private static String contentPath;
	
	static{
		InetAddress ia=null;
		try {
		ia=ia.getLocalHost();
		contentPath="http://"+ia.getHostAddress()+":8088/grass";
//		System.out.println("本机的ip是 ："+contentPath);
		} catch (Exception e) {
		e.printStackTrace();
		}
		
//		Properties cfg = new Properties();//散列表	key-value
//		try {
//			InputStream in = DBUtil.class.getClassLoader().getResourceAsStream("ip.properties");
//			cfg.load(in);
//			//初始化参数
//			contentPath = cfg.getProperty("contentPath");
//			in.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new RuntimeException(e);
//		}
	}
	
	public static String getContentpath(){
		return contentPath;
	}
}
