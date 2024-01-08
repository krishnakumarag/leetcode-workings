package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Refer - https://leetcode.com/problems/zigzag-conversion/
 */
public class ZigzagConversion {

	private void fillDummyList(List<List<Character>> values, int numRows) {
		for (int i = 0; i < numRows; i++) {
			values.add(new ArrayList<>());
		}
	}

	private String getResult(List<List<Character>> values) {
		StringBuilder allLines = new StringBuilder();
		values.forEach(lines -> {
			lines.forEach(ch -> {
				allLines.append(ch.toString());
			});
		});
		return allLines.toString();
	}

	public String convert(String s, int numRows) {
		String result = null;
		if (s != null) {

			List<List<Character>> values = new ArrayList<>(numRows);
			fillDummyList(values, numRows);

			char str[] = s.toCharArray();
			int i = 0;
			int idx = 0;
			while (i < str.length) {
				while (idx < numRows && i < str.length) {
					List<Character> lines = values.get(idx);
					lines.add(str[i]);
					idx++;
					i++;
				}
				idx = numRows == 1 ? 0 : numRows - 2;

				while (idx > -1 && i < str.length) {
					List<Character> lines = values.get(idx);
					lines.add(str[i]);
					idx--;
					i++;
				}
				idx = 1;
			}

			result = getResult(values);
		}
		return result;
	}

	public static void main(String[] args) {
		ZigzagConversion zc = new ZigzagConversion();
//		System.out.println(zc.convert("PAYPALISHIRING", 3));
		//		System.out.println(zc.convert("PAYPALISHIRING", 4));
		//		System.out.println(zc.convert("A", 1));
				System.out.println(zc.convert("AB", 1));
	}
}
