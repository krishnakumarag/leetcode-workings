package medium;

/**
 * Refer - https://leetcode.com/problems/string-to-integer-atoi/
 */
public class Atoi {

	private boolean isNumber(String a) {
		boolean isNumber = false;
		try {
			Double.parseDouble(a);
			isNumber = true;
		} catch (NumberFormatException ignored) {

		}
		return isNumber;
	}

	public int myAtoi(String s) {
		int result = 0;
		if (s != null) {
			StringBuilder strRes = new StringBuilder();
			char[] a = s.toCharArray();
			for (int i = 0; i < a.length; i++) {
				char c = a[i];
				if (c != ' ' && c != '+' && c != '-' && !isNumber(String.valueOf(c))) {
					break;
				}
				if (isNumber(String.valueOf(c)) || c == '+' || c == '-') {
					strRes.append(c);
					if ((i + 1) < a.length && !isNumber(String.valueOf(a[(i + 1)]))) {
						break;
					}
				}
			}
			if (strRes.length() > 0 && isNumber(strRes.toString())) {
				double finalResult = Double.parseDouble(strRes.toString());
				if (Integer.MIN_VALUE < finalResult && Integer.MAX_VALUE > finalResult) {
					result = (int) finalResult;
				} else {
					result = finalResult < 0 ? (Integer.MAX_VALUE + 1) * -1 : Integer.MAX_VALUE;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Atoi a = new Atoi();
		System.out.println(a.myAtoi("42"));
		System.out.println(a.myAtoi("   -42"));
		System.out.println(a.myAtoi("4193 with words"));
		System.out.println(a.myAtoi("a 1234 abcd"));
		System.out.println(a.myAtoi("-91283472332"));
		System.out.println(a.myAtoi("+-12"));
		System.out.println(a.myAtoi("   +0 123"));
		System.out.println(a.myAtoi("20000000000000000000"));
		System.out.println(a.myAtoi("-5-"));
	}
}
