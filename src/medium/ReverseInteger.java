package medium;

/**
 * Refer - https://leetcode.com/problems/reverse-integer/description/
 */
public class ReverseInteger {
	public int reverse(int x) {
		long reversed = 0;

		int digits = 10;
		while (x != 0) {
			reversed = (reversed * digits) + (x % 10);
			x = x / 10;
		}
		if (x < 0) {
			reversed = reversed * -1;
		}
		reversed = reversed > Integer.MIN_VALUE && reversed < Integer.MAX_VALUE ? reversed : 0;
		return (int) reversed;
	}

	public static void main(String[] args) {
		ReverseInteger re = new ReverseInteger();
		System.out.println(re.reverse(123));
		System.out.println(re.reverse(-123));
		System.out.println(re.reverse(120));
		System.out.println(re.reverse(1534236469));

	}
}
