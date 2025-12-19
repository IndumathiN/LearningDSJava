package com.indu.subarray;

import java.util.Arrays;

public class CountingSALessThanB {
    static int solve_BruteForce(int b, int[] arr) {
        int n =arr.length;
        int count=0;
        if(n != 0) {
            for (int start = 0; start < n; start++) {

                for (int end = start; end < n; end++) {
                    int sum = 0;
                    // print subarray from start to end
                    for (int k = start; k <= end; k++) {
                        System.out.print(arr[k] + " ");
                        sum = sum + arr[k];

                    } System.out.println("[" + start + "," + end + "] = " + sum);
                    if(sum < b){
                        count=count+1;
                    }
                    System.out.println();
                }
                System.out.println("Sum of sub array at index " + start + "is ");
                System.out.println();

            }
        }
        return count;
    }
    static int solve_prefixSum(int b, int[] arr) {
        int n =arr.length;
        int count =0;
        if(n !=0) {
            int[] ps = new int[n];
            ps[0] = arr[0];

            for (int i = 1; i < n; i++) {
                ps[i] = arr[i] + ps[i - 1];
            }
            System.out.println("Prefix Sum for array" + Arrays.toString(arr) + " is " + Arrays.toString(ps));
            for (int start = 0; start < n; start++) { //start=0
                int sum = 0;
                int saSum = 0;
                for (int end = start; end < n; end++) {  //it1: [0,0]end =0
                    if (start == 0) {
                        saSum = ps[end];
                    } else {
                        saSum = ps[end] - ps[start - 1];
                    }
                    System.out.println("[" + start + "," + end + "] = " + saSum);
                    if (saSum < b) {
                        count = count + 1;
                    }
                }
                System.out.println("Sum of sub array at index " + start + "is " + saSum);
            }
        }
        return count;
    }
    static int solve_CarryForward(int b, int[] arr) {
        int n = arr.length;
        int count=0;
        if(n != 0) {
            for (int start = 0; start < n; start++) {
                int sum = 0; // reset for each start

                for (int end = start; end < n; end++) {
                    sum = sum + arr[end];   // carry forward
                    System.out.println("Subarray [" + start + "," + end + "] Sum = " + sum);
                   if (sum < b) {
                        count = count + 1;
                    }
                }

            }
        }
        return count;
    }



    public static void main(String[] args) {
        CountingSALessThanB sa= new CountingSALessThanB();
        int[] array1 = {2,5,6};
        int[] arr = {1, 11, 2, 3, 15};
        int[] arr2={10, 15, 20};
        int[] arr3={1, 2, 3};
        int[] arr4={};
        int[] arr5={5};
        int[] arr6={15};



        int count_bf=sa.solve_BruteForce(10,array1);
        System.out.println("TC for Brute Force Approach is O(N^3), SC:O(1) and count is "+count_bf);
//        int count_pf= sa.solve_prefixSum(10,arr5);
//        System.out.println("TC for Prefix sum Approach is O(N^2), SC:O(N), and count is "+count_pf);
//
//        int count_cf=sa.solve_CarryForward(10,arr);
//        System.out.println("TC for carry forward Approach is O(N^2), SC:O(1) and count is "+count_cf);


    }
}
