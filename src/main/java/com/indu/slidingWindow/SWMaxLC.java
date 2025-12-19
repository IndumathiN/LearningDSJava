package com.indu.slidingWindow;

import com.indu.subarray.SlidingWindow;

import java.util.Arrays;

public class SWMaxLC {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n= nums.length;
        int windowSize=n-k+1;
        int[] output =new int[windowSize];
        int max=Integer.MIN_VALUE;
        //Window 1 : generation
        for(int i=0;i<k;i++){
            if(nums[i]>max){
                max=Math.max(nums[i],max);
             }
        }
        output[0]=max;
        System.out.println(Arrays.toString(output));
        System.out.println("Max is "+max);
        for(int start=1; start<=n-k;start++){
            int end = start+k-1;
            if(nums[end]>max){
                max=Math.max(nums[end],max);
                System.out.println("end "+end +" max is "+max);
                output[start]=nums[end];
            } else {
                output[start]=max;
            }
        }
        return output;
    }
    public static void main(String[] args) {
        SWMaxLC sa = new SWMaxLC();
        int[] array1 = {1,3,-1,-3,5,3,6,7};
        int[] max =sa.maxSlidingWindow(array1,3);
        System.out.println(Arrays.toString(max));
    }
}
