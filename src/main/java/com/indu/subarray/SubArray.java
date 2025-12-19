package com.indu.subarray;

import java.util.Arrays;

public class SubArray {

    static void printSumSA_BruteForce(int[] arr) {
        int n =arr.length;
        for (int start = 0; start < n; start++) {
            int sum=0;
            for (int end = start; end < n; end++) {
                // print subarray from start to end
                for (int k = start; k <= end; k++) {
                    System.out.print(arr[k] + " ");
                    sum=sum+arr[k];
                }
                System.out.println();
            }
            System.out.println("Sum of sub array at index "+start +"is "+sum);
            System.out.println();
            sum=0;
        }
    }
    static void printSumSA_prefixSum(int[] arr) {
        int n =arr.length;
        int[] ps=new int[n];
        ps[0]=arr[0];
        for(int i=1;i<n;i++){
            ps[i]=arr[i]+ps[i-1];
        }
        System.out.println("Prefix Sum for array"+Arrays.toString(arr)+" is "+Arrays.toString(ps));
        for(int start=0;start<n;start++){ //start=0
            int sum=0;
            int saSum=0;
            for(int end=start;end<n;end++){  //it1: [0,0]end =0
                if(start==0){
                    saSum=ps[end];
                }  else {
                    saSum=ps[end]-ps[start-1];
                }
                sum=sum+saSum;
            }
            System.out.println("Sum of sub array at index "+start +"is "+sum);
        }
    }
    static void printSumSA_CarryForward(int[] arr) {
        int n = arr.length;

        for (int start = 0; start < n; start++) {
            int sum = 0; // reset for each start
            int tsaSum=0;
            for (int end = start; end < n; end++) {
                sum = sum + arr[end];   // carry forward
                System.out.println("Subarray [" + start + "," + end + "] Sum = " + sum);
                tsaSum=tsaSum+sum;
            }

            System.out.println("Total subarray sum at index "+start +" is "+tsaSum);
            System.out.println();
        }
    }



    public static void main(String[] args) {
        SubArray sa= new SubArray();
        int[] array1 = {2, 1, 3, 4, 5};
        int[] arr = {2, 6, 1, 6, 9, 1};
        int[] cf_arr = {1, 2, 3, 1, 3, 4, 6, 4, 6, 3};
//        sa.printSumSA_BruteForce(array1);
//        System.out.println("TC for Brute Force Approach is O(N^3), SC:O(1)");
        sa.printSumSA_prefixSum(array1);
        System.out.println("TC for Prefix sum Approach is O(N^2), SC:O(N)");
//        sa.printSumSA_CarryForward(array1);
//        System.out.println("TC for carry forward Approach is O(N^2), SC:O(1)");


    }
}
