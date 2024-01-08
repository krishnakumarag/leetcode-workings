package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Refer - https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationPhoneNumber {

	static Map<Character, List<Character>> numberMap = new HashMap<>();

	static {
		numberMap.put('2', List.of('a', 'b', 'c'));
		numberMap.put('3', List.of('d', 'e', 'f'));
		numberMap.put('4', List.of('g', 'h', 'i'));
		numberMap.put('5', List.of('j', 'k', 'l'));
		numberMap.put('6', List.of('m', 'n', 'o'));
		numberMap.put('7', List.of('p', 'q', 'r', 's'));
		numberMap.put('8', List.of('t', 'u', 'v'));
		numberMap.put('9', List.of('w', 'x', 'y', 'z'));
	}

	public List<String> letterCombinations(String digits) {
		if (digits.isEmpty())
			return Collections.emptyList();

		List<String> output = new ArrayList<>();
		backtrack("", digits, output);
		return output;
	}

	private void backtrack(String combination, String next_digits, List<String> output) {
		if (next_digits.isEmpty()) {
			output.add(combination);
		} else {
			List<Character> letters = numberMap.get(next_digits.charAt(0));
			for (char letter : letters) {
				backtrack(combination + letter, next_digits.substring(1), output);
			}
		}
	}

	public static void main(String[] args) {
		LetterCombinationPhoneNumber lc = new LetterCombinationPhoneNumber();
		System.out.println(lc.letterCombinations("23"));
	}
}
