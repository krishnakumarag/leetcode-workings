package easy;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Refer - https://leetcode.com/problems/assign-cookies/?envType=daily-question&envId=2024-01-01
 */
public class AssignCookies {

	public int findContentChildren(int[] g, int[] s) {
		int output = 0;
		if (g != null && s != null) {
			Arrays.sort(g);
			Arrays.sort(s);
			int intialPos = 0;
			for (int child : g) {
				int lastValue = intialPos;
				while (lastValue < s.length) {
					if (s[lastValue] >= child) {
						output++;
						intialPos = lastValue + 1;
						break;
					}
					lastValue++;
				}
			}
		}
		return output;
	}

	public static void main(String[] args) {
		System.out.println(new AssignCookies().findContentChildren(new int[] { 1, 2, 3 }, new int[] { 1, 1 }));
		System.out.println(new AssignCookies().findContentChildren(new int[] { 1, 2 }, new int[] { 1, 2, 3 }));
		System.out.println(new AssignCookies().findContentChildren(new int[] { 4, 5, 6 }, new int[] { 1, 7, 3 }));

		System.out.println(new AssignCookies().findContentChildren(new int[] { 10, 9, 8, 7 }, new int[] { 5, 6, 7, 8 }));
	}
}

