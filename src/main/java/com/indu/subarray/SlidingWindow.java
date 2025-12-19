package com.indu.subarray;

import java.util.Arrays;

public class SlidingWindow {

    static void printSA(int k, int[] arr) {
        int n = arr.length;
        for (int start = 0; start <= n - k; start++) {
            int end = start + k - 1;
            System.out.println("Start Index = " + start + ", End Index = " + end);
        }
    }

    static int maxSASum_bf(int k, int[] arr) {
        int n = arr.length;
        int max=Integer.MIN_VALUE;
        for (int start = 0; start <= n - k; start++) {
            int end = start + k - 1;
            int saSum=0;
            for(int i=start;i<=end;i++){
                saSum+=arr[i];
             }
            max=Math.max(saSum,max);
            System.out.println("Start Index = " + start + ", End Index = " + end+" Sum: "+saSum);
        }
        return max;
    }
    static int maxSASum_prefixSum(int k, int[] arr) {
        int max=Integer.MIN_VALUE;
        int n=arr.length;
        int[] prefSum=new int[n];
        prefSum[0]=arr[0];
        for(int i=1;i<n;i++){ //TC:O(N)
            prefSum[i]=arr[i]+prefSum[i-1];
        }
        System.out.println(Arrays.toString(prefSum));
        for (int start = 0; start <= n - k; start++) { //TC: n-k+1
            int end = start + k - 1;
            int saSum=0;
            if(start == 0){
                saSum=prefSum[end];
            } else {
                saSum=prefSum[end]-prefSum[start-1];
            }
            max=Math.max(saSum,max);
        }
        return max;
    }
    static int maxSASum_slidingWindow(int k, int[] arr) {
        int n=arr.length;
        if (n < k) return -1; //edge cases;
        int saSum=0;
        for(int i=0;i<k;i++){
            saSum+=arr[i];
        }
        int max=saSum;

        for (int start = 1; start <= n - k; start++) {
            int end = start + k - 1; //1+3-1 =3
            saSum=saSum-arr[start-1]+arr[end];
            max=Math.max(saSum,max);
        }
        return max;
    }
    public static void main(String[] args) {
        SlidingWindow sa = new SlidingWindow();
        int[] array1 = {-3,4,-2,5,3,-2,8,2,-1,4};
        int[] arr = {2, 6, 1, 6, 9, 1};
        int[] cf_arr = {1, 2, 3, 1, 3, 4, 6, 4, 6, 3};
        int maxSA=sa.maxSASum_bf(5,array1);

        System.out.println("Max SA sum: (N-k+1)*k "+maxSA);
        int maxpf=sa.maxSASum_prefixSum(5,array1);
        System.out.println("Max SA sum with prefix Sum"+maxpf);
        int maxSw=sa.maxSASum_slidingWindow(5,array1);
        System.out.println("Max SA sum with Sliding Window "+maxSw);

    }
}
