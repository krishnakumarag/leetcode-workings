package medium;

import java.util.Map;
import java.util.TreeMap;

/**
 * Refer - https://leetcode.com/problems/integer-to-roman/
 */
public class IntegerToRoman {

	private static Map<Integer, String> romanMap = new TreeMap<>();

	static {
		romanMap.put(1, "I");
		romanMap.put(4, "IV");
		romanMap.put(5, "V");
		romanMap.put(9, "IX");
		romanMap.put(10, "X");
		romanMap.put(40, "XL");
		romanMap.put(50, "L");
		romanMap.put(90, "XC");
		romanMap.put(100, "C");
		romanMap.put(400, "CD");
		romanMap.put(500, "D");
		romanMap.put(900, "CM");
		romanMap.put(1000, "M");
	}

	private int getDigits(int num) {
		int count = 0;
		while (num != 0) {
			num = num / 10;
			count++;
		}
		return count - 1;
	}

	public String intToRoman(int num) {
		String roman = null;
		if (0 < num && num < 4000) {
			int digits = getDigits(num);
			StringBuilder romanLetter = new StringBuilder();
			while (num != 0) {
				int decimal = 1;
				for (int i = 0; i < digits; i++) {
					decimal = decimal * 10;
				}
				int n = (int) (((double) num / decimal) * decimal);
				if (n == 0) {
					n = num % 10;
				}
				if (romanMap.containsKey(n)) {
					romanLetter.append(romanMap.get(n));
				} else {
					String nearstRoman = null;
					int nearestNumber = 0;
					for (Map.Entry<Integer, String> entry : romanMap.entrySet()) {
						if (entry.getKey() < n) {
							nearstRoman = entry.getValue();
							nearestNumber = entry.getKey();
						} else {
							break;
						}
					}
					romanLetter.append(nearstRoman);
					n = nearestNumber;
					if (num < 10) {
						int remain = num - n;
						for (int i = 0; i < remain; i++) {
							romanLetter.append(romanMap.get(1));
							n++;
						}
					}
				}
				num = num - n;
				digits--;
			}
			roman = romanLetter.toString();
		}
		return roman;
	}

	public static void main(String[] args) {
		IntegerToRoman ir = new IntegerToRoman();
		System.out.println(ir.intToRoman(3));
		System.out.println(ir.intToRoman(58));
		System.out.println(ir.intToRoman(1994));
		System.out.println(ir.intToRoman(20));
		System.out.println(ir.intToRoman(30));
		System.out.println(ir.intToRoman(1011));

	}
}
