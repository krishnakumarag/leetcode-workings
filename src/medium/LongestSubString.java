package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Refer - https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubString {

	public int lengthOfLongestSubstring(String s) {
		int n = s.length();
		int maxLength = 0;
		Set<Character> charSet = new HashSet<>();
		int left = 0;

		for (int right = 0; right < n; right++) {
			if (!charSet.contains(s.charAt(right))) {
				charSet.add(s.charAt(right));
				maxLength = Math.max(maxLength, right - left + 1);
			} else {
				while (charSet.contains(s.charAt(right))) {
					charSet.remove(s.charAt(left));
					left++;
				}
				charSet.add(s.charAt(right));
			}
		}

		return maxLength;
	}

	public static void main(String[] args) {
		LongestSubString ls = new LongestSubString();
		System.out.println(ls.lengthOfLongestSubstring("abcabcbb"));
//		System.out.println(ls.lengthOfLongestSubstring("bbbbb"));
//		System.out.println(ls.lengthOfLongestSubstring("pwwkew"));
//		System.out.println(ls.lengthOfLongestSubstring("abcd"));
//		System.out.println(ls.lengthOfLongestSubstring(" "));
//		System.out.println(ls.lengthOfLongestSubstring("dvdf"));
	}
}
