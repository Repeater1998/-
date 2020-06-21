package bean;

public class Crypto {
	
	public static String encrypt(String sourceString, String password) {
        char[] p = password.toCharArray(); // �ַ���ת�ַ�����
        int n = p.length; // ���볤��
        char[] c = sourceString.toCharArray();
        int m = c.length; // �ַ�������
        for (int k = 0; k < m; k++) {
            int mima = c[k] + p[k / n]; // ����
            c[k] = (char) mima;
        }
        return new String(c);
    }

    /**
     *
     * @param sourceString
     * @param password
     * @return ����
     */
    public static String decrypt(String sourceString, String password) {
        char[] p = password.toCharArray(); // �ַ���ת�ַ�����
        int n = p.length; // ���볤��
        char[] c = sourceString.toCharArray();
        int m = c.length; // �ַ�������
        for (int k = 0; k < m; k++) {
            int mima = c[k] - p[k / n]; // ����
            c[k] = (char) mima;
        }
        return new String(c);
    }
}
