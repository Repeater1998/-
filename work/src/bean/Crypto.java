package bean;

public class Crypto {
	
	public static String encrypt(String sourceString, String password) {
        char[] p = password.toCharArray(); // 字符串转字符数组
        int n = p.length; // 密码长度
        char[] c = sourceString.toCharArray();
        int m = c.length; // 字符串长度
        for (int k = 0; k < m; k++) {
            int mima = c[k] + p[k / n]; // 加密
            c[k] = (char) mima;
        }
        return new String(c);
    }

    /**
     *
     * @param sourceString
     * @param password
     * @return 明文
     */
    public static String decrypt(String sourceString, String password) {
        char[] p = password.toCharArray(); // 字符串转字符数组
        int n = p.length; // 密码长度
        char[] c = sourceString.toCharArray();
        int m = c.length; // 字符串长度
        for (int k = 0; k < m; k++) {
            int mima = c[k] - p[k / n]; // 解密
            c[k] = (char) mima;
        }
        return new String(c);
    }
}
