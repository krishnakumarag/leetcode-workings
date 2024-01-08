package medium;

/**
 * Refer - https://leetcode.com/problems/container-with-most-water/
 */
public class MostWater {

	public int maxArea_solu(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int maxArea = 0;

		while (left < right) {
			int currentArea = Math.min(height[left], height[right]) * (right - left);
			maxArea = Math.max(maxArea, currentArea);

			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}

		return maxArea;
	}

	public int maxArea(int[] heights) {
		int max = 0;
		int n = heights.length;
		if (2 <= n && n < Math.pow(10, 5)) {
			int multiplier = 0;
			int selectedLength = 0;
			int selectedHeight = heights[0];
			for (int i = 1; i < n; i++) {
				int height = heights[i];
				if (height > selectedHeight) {
					selectedHeight = height;
					selectedLength = height;
					multiplier = 0;
				} else {
					if (selectedHeight >= selectedLength) {
						selectedLength = height;
						multiplier++;
					}
				}

			}
			max = selectedLength * (multiplier);
		}
		return max;
	}

	public static void main(String[] args) {
		MostWater m = new MostWater();
				int[] abc = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
				System.out.println(m.maxArea_solu(abc));
//		int[] abc2 = { 1, 2, 1 };
//		System.out.println(m.maxArea(abc2));
	}
}
