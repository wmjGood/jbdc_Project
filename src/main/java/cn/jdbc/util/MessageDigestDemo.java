package cn.jdbc.util;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

public class MessageDigestDemo {
	public void run() {
		String text = "19941203";
		byte data[] = null;
		MessageDigest m;
		try {
			data = text.getBytes("UTF8");
			//计算信息摘（即散列码）要做的第一步是创建 MessageDigest对象 实例。像所有的引擎类一样，获取某类报文摘要算法（即散列算法，比如MD5）的  MessageDigest 对象的途径是调用 MessageDigest 类中的 getInstance
			m = MessageDigest.getInstance("MD5");//生成MessageDigest对象
			//计算数据的摘要的第二步是向已初始化的MessageDigest对象提供传送要计算的数据
			m.update(data);//传入需要计算的字符串
			//通过调用 update 方法向MessageDigest对象提传送要计算的数据后，你就可以调用以下某个 digest（摘要）方法来计算摘要（即生成散列码）
			byte resultData[] = m.digest();//计算消息摘要
			System.out.println(convertToHexString(resultData));//处理计算结果
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	static String convertToHexString(byte data[]) {
		StringBuffer strBuffer = new StringBuffer();
		for (int i = 0; i < data.length; i++) {
			strBuffer.append(Integer.toHexString(0xff & data[i]));
		}
		return strBuffer.toString();
	}

	@Test
	public void testMd5() throws Exception {
		run();
	}

}

