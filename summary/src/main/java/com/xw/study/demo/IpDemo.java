package com.xw.study.demo;

/**
 * ip：192.168.1.1 通过4个byte（注意符号位）存储 前面不好不要懵，要稳
 */
public class IpDemo {

	public static void main(String[] args) throws Exception {
		System.out.println(ip2Long("255.255.255.255"));
		System.out.println(Long.MAX_VALUE >> 31);
		
		System.out.println(long2IP(4294967294L));
	}

	/**
	 * @throws Exception
	 */
	public static long ip2Long(String ipStr) throws Exception {

		long[] ip = new long[4];

		String[] ipStrs = ipStr.split("\\.");
		if (ipStrs.length != 4) {
			throw new Exception("地址非法1");
		}
		for (int i = 0; i < ipStrs.length; i++) {
			if (ipStrs[i].length() > 3) {
				throw new Exception("地址非法2");
			}
			try {
				Integer.parseInt(ipStrs[i]);
			} catch (Exception e) {
				throw new Exception("地址非法3");
			}
		}

		ip[0] = Long.parseLong(ipStrs[0]);
		ip[1] = Long.parseLong(ipStrs[1]);
		ip[2] = Long.parseLong(ipStrs[2]);
		ip[3] = Long.parseLong(ipStrs[3]);
		return (ip[0] << 24) + (ip[1] << 16) + (ip[2] << 8) + ip[3];
	}

	public static String long2IP(long ipLong) {
		StringBuffer ipResult = new StringBuffer();

		return ipResult.append(String.valueOf((ipLong >>> 24))).append(".")
				.append(String.valueOf((ipLong & 0x00FFFFFF) >>> 16)).append(".")
				.append(String.valueOf((ipLong & 0x0000FFFF) >>> 8)).append(".")
				.append(String.valueOf((ipLong & 0x000000FF))).toString();
	}
}
