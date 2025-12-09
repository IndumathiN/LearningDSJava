package com.indu.session1;

import java.util.Arrays;

public class CountPairs {


        // Function to count pairs with sum = k
        public static int goodPair(int[] arr, int k) {
            int count = 0;
            for (int i = 0; i < arr.length; i++) { //[0,n-1]=n-1-0+1=n
                for (int j = i + 1; j < arr.length; j++) { // i != j
                    //[i+1,n-1]=n-1-i-1+1=n-1-i
                    //(n-1)+(n-2)+(n-3)+....+1 =[n(n-1)]/2=(n^2-n)/2
                    // Time Complexity=O(N^2) Space Complexity=O(1)
                    if (arr[i] + arr[j] == k) {
                        System.out.println("("+arr[i]+","+arr[j]+")");
                        count++;
                    }
                }
            }
            return count;
        }

    public static int[] revArr(int[] arr) {
        int[] revArray = new int[arr.length];
        int index = 0;
        //Time complexity =[0,n-1]= O(N) ; Space Complexity : O(N)  (as array is initailised)
        for (int i = arr.length - 1; i >= 0; i--) {
            revArray[index] = arr[i];
            index++;
        }

        return revArray;
    }


    public static int[] subarray(int[] arr, int B, int C) {
        // Validate indices
        if (arr == null || B < 0 || C >= arr.length || B > C) {
            return new int[0]; // return empty array for invalid input
        }

        int size = C - B + 1;
        int[] subArr = new int[size];

        for (int i = 0; i < size; i++) {
            subArr[i] = arr[B + i];
        }

        return subArr;
    }
        // Function to reverse subarray from B to C inclusive
        public static int[] revArrFrmRange(int[] arr, int b, int c) {
            //Time complexity : O(C-B+1) Space complexity: O(C-B+1)
            if (arr == null || b < 0 || c >= arr.length || b > c) {
                return new int[0];
            }

            int size = c - b + 1;
            int[] output = new int[size];
            int index = 0;

            for (int i = b; i <= c; i++) {  // loop from b to c
                output[index] = arr[i];
                index++;
            }

            return output;
        }


        public static void main(String[] args) {
            int[] arr = {2, 7, 3, 14, 6, 1, 0, 10, 14};
            int sum = 20;
            System.out.println("1)Number of pairs with sum " + sum + ": " + goodPair(arr, sum));

            System.out.println("****2)Reversed Array*************");
            int[] revArrInput={1,2,3,2,1};
            int[] revArrInput1={1,1,10};
            System.out.println(Arrays.toString(revArr(revArrInput)));
            System.out.println(Arrays.toString(revArr(revArrInput1)));

            int[] A = {1, 2, 3, 4, 5, 6, 7};
            int B = 2;
            int C = 5;

            System.out.println("Original array: " + Arrays.toString(A));

            System.out.println("Array after reversing from index " + B + " to " + C + ": " + Arrays.toString(subarray(A, B, C)));

            System.out.println("Array after reversing from index " + B + " to " + C + ": " + Arrays.toString(revArrFrmRange(A, B, C)));
        }


}
