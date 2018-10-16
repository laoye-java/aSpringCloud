package aStreamProducers;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress inetAddress ;//声明InetAddress对象
		inetAddress = InetAddress.getLocalHost();//实例化InetAddress对象，返回本地主机
		String hostName=inetAddress.getHostName();//获取本地主机名
		String canonicalHostName = inetAddress.getCanonicalHostName();//获取此 IP地址的完全限定域名
		System.out.println(hostName);
		System.out.println(canonicalHostName);
	}
}
