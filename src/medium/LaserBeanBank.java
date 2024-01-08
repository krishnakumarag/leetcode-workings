package medium;

/**
 * Refer - https://leetcode.com/problems/number-of-laser-beams-in-a-bank/?envType=daily-question&envId=2024-01-03
 */
public class LaserBeanBank {

	private int getNoOfOnes(String s) {
		int noOfOne = 0;
		if (s != null && !s.isBlank()) {
			for (char c : s.toCharArray()) {
				if (c == '1')
					noOfOne++;
			}
		}
		return noOfOne;
	}

	public int numberOfBeams(String[] bank) {
		int count = 0;
		if (bank != null) {
			int st = 0;
			boolean increaseSt;
			while (st < bank.length) {
				String str = bank[st];
				increaseSt = true;
				if (str.contains("1")) {
					int ones = getNoOfOnes(str);
					int j = st + 1;
					while (j < bank.length) {
						String s = bank[j];
						if (s.contains("1")) {
							count = count + (ones * getNoOfOnes(s));
							st = j;
							increaseSt = false;
							break;
						}
						j++;
					}
				}
				if (increaseSt)
					st++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
//		System.out.println(new LaserBeanBank().numberOfBeams(new String[] { "011001", "000000", "010100", "001000" }));
//		System.out.println(new LaserBeanBank().numberOfBeams(new String[] { "000", "111", "000" }));
//		System.out.println(new LaserBeanBank().numberOfBeams(new String[] { "011001", "000000", "001000" }));


	}
}
