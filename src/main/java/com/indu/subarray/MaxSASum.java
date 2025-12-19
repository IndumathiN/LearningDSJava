package com.indu.subarray;

import java.util.Arrays;

public class MaxSASum {
    static int maxSASum_prefixSum(int b,int[] arr) {
        int n =arr.length;
        int[] ps=new int[n];
        int maxSum=0;
        ps[0]=arr[0];
        if (ps[0] <= b) {
            maxSum = ps[0];
        }
        for(int i=1;i<n;i++){
            ps[i]=arr[i]+ps[i-1];
            if(ps[i] <=b){
                maxSum=Math.max(maxSum,ps[i]);
            }
        }
        System.out.println("Prefix Sum for array"+ Arrays.toString(arr)+" is "+Arrays.toString(ps)+" max sum is "+maxSum);
        for(int start=0;start<n;start++){ //start=0

            int saSum=0;
            for(int end=start;end<n;end++){  //it1: [0,0]end =0
                if(start==0){
                    saSum=ps[end];
                }  else {
                    saSum=ps[end]-ps[start-1];
                }
                if(saSum <=b){
                    maxSum=Math.max(maxSum,saSum);
                }
            }

        }
        return maxSum;
    }
    static int maxSumSA_CarryForward(int b,int[] arr) {
        int n = arr.length;
        int maxSum=0;

        for (int start = 0; start < n; start++) {
            int sum = 0; // reset for each start

            for (int end = start; end < n; end++) {
                sum = sum + arr[end];   // carry forward
                System.out.println("Subarray [" + start + "," + end + "] Sum = " + sum);

                if(sum <=b){
                   maxSum=Math.max(maxSum,sum);
                }
            }

        }
        return maxSum;
    }
    public static void main(String[] args) {
        MaxSASum maxSASum= new MaxSASum();

//        int b=12;
        int[] array1 = {2, 2, 2};
        int b=1;
        int maxsum_pf=maxSASum.maxSASum_prefixSum(b,array1);
        System.out.println("MaxSA Sum with PrefixSum with b<= "+ b+" is "+maxsum_pf);

        int[] array={2, 1, 3, 4, 5};
        int maxsum_cf=maxSASum.maxSumSA_CarryForward(12,array);
        System.out.println("MaxSA Sum with Carry forward with b <= 12is "+maxsum_cf);
    }
}
