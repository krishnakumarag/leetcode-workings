package medium;

import java.util.Arrays;

public class LongestIncreseSubString {

	public int lengthOfLIS(int[] nums) {
		int[] temp = new int[nums.length];
		int len = 1;
		temp[0] = nums[0];

		for (int i = 1; i < nums.length; i++) {
			if (temp[len - 1] < nums[i]) {
				temp[len++] = nums[i];
			} else {
				int ind = Arrays.binarySearch(temp, 0, len, nums[i]);
				if (ind < 0) {
					ind = -(ind + 1);
				}
				temp[ind] = nums[i];
			}
		}
		return len;
	}

	public static void main(String[] args) {        
		System.out.println(new LongestIncreseSubString().lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));
		System.out.println(new LongestIncreseSubString().lengthOfLIS(new int[] { 0, 1, 0, 3, 2, 3 }));
	}
}
