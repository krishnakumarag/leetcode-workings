package medium.arrays;

/**
 * Refer - https://leetcode.com/problems/find-the-original-array-of-prefix-xor/description/
 */
public class ArrayOfPrefixXOR {


    public int[] findArray(int[] pref) {
        int result[]=new int[pref.length];
        result[0]=pref[0];
        int sum = result[0];
        for(int i=1;i<pref.length;i++){
            int val = sum ^ pref[i];
            result[i] = val;
            sum = sum ^ val;
        }
        return result;
    }

    public static void main(String[] args) {
       int result[] = new ArrayOfPrefixXOR().findArray(new int[]{13});
     for (int result2 : result) {
        System.out.println(result2);
     }
    }
    
}
