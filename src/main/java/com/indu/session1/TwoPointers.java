package com.indu.session1;

import java.util.Arrays;

class TwoPointers {

    public static int[] reverseRange(int[] arr, int B, int C) {
        int left = B;
        int right = C;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        return arr;
    }

    public static int[] twoPointersRevarray(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        return arr;
    }
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");

        int[] arr = {-3, 4, 7, 8, 11, 9, 5, 2, 10};

        System.out.println(Arrays.toString(twoPointersRevarray(arr)));

        System.out.println(Arrays.toString(reverseRange(arr,2,6)));
    }
}

