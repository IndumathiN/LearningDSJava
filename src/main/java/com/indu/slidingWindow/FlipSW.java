package com.indu.slidingWindow;

import com.indu.subarray.SlidingWindow;

public class FlipSW {
    static int atmostKFlips0(int k, int[] arr){
        int maxones=Integer.MIN_VALUE;
        int start=0;
        int count_zero=0;

        for(int end=0;end < arr.length;end++){
            if(arr[end]==0){
                count_zero++;
             }
            while (count_zero > k){
                if(arr[start]==0) {
                    count_zero--;
                } start++;
            }
            maxones=Math.max(maxones, end-start+1);
        }
        return  maxones;
    }
    static int atmost1Flips0(int[] arr){
        int maxones=Integer.MIN_VALUE;
        int start=0;
        int count_zero=0;

        for(int end=0;end < arr.length;end++){
            if(arr[end]==0){
                count_zero++;
            }
            while (count_zero > 1){
                if(arr[start]==0) {
                    count_zero--;
                } start++;
            }
            maxones=Math.max(maxones, end-start+1);
        }
        return  maxones;
    }
    public static void main(String[] args) {
        FlipSW fw = new FlipSW();
        int[] array1 = {1,1,1,0,0,0,1,1,1,1,0};
        int[] array2 ={0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int maxConones=fw.atmostKFlips0(3,array2);
        System.out.println("Max 1's after k flips is "+maxConones);

        int maxCononesat1=fw.atmost1Flips0(array2);
        System.out.println("Max 1's after k flips is "+maxCononesat1);
    }
}
