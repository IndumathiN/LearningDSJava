package com.indu.slidingWindow;

import com.indu.subarray.SubArray;

public class BinaryArray {
    static int maxConsecutiveOnes(int[] nums) {
        int max1s = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                max1s = Math.max(max1s, count);
            } else {
                count = 0; // reset when 0 appears
            }
        }
        return max1s;
    }
    static int maxConsecutiveOnes_SlidingWindow(int[] nums) {
        int start = 0;
        int maxLen = 0;

        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == 0) {
                start = end + 1; // reset window after zero
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        BinaryArray ba= new BinaryArray();
        int[] array1 = {1,1,0,1,1,1};

        int maxConsecutiveOnes=ba.maxConsecutiveOnes(array1);
        System.out.println("Max Consecutive 1's is : "+maxConsecutiveOnes);

        int maxConsecutiveOnes_sw=ba.maxConsecutiveOnes_SlidingWindow(array1);
        System.out.println("Max Consecutive 1's with SW is : "+maxConsecutiveOnes_sw);

    }

}
