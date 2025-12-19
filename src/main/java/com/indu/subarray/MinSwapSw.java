package com.indu.subarray;

import java.util.ArrayList;

public class MinSwapSw {
    static int minSwap_bf(int b, int[] arr) {
        int n = arr.length;

        // Step 1: count good elements
        ArrayList<Integer> goodElements = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(arr[i] <= b){
                goodElements.add(arr[i]);
            }
        }
        int windowLength = goodElements.size();
        ArrayList<ArrayList<Integer>> allWindows = new ArrayList<>();

        // Step 2: generate windows
        for(int start = 0; start <= n - windowLength; start++){
            ArrayList<Integer> windowArray = new ArrayList<>();

            for(int end = start; end <= start + windowLength - 1; end++){
                windowArray.add(arr[end]);
                System.out.print(arr[end]+" ");
            }
            allWindows.add(windowArray);
            System.out.println();
        }

        // Step 3: calculate min swaps
        int minSwap = Integer.MAX_VALUE;

        for(int i = 0; i < allWindows.size(); i++){
            ArrayList<Integer> window = allWindows.get(i);

            int goodCount = 0;
            for(int j = 0; j < window.size(); j++){
                if(window.get(j) <= b){
                    goodCount++;
                }
            }

            int badCount = windowLength - goodCount;
            minSwap = Math.min(minSwap, badCount);
        }

        System.out.println("BruteForce MinSwap: " + minSwap);
        return minSwap;
    }
    static void minSwap_slidingWindow_myLogic(int b, int[] arr) {
        int n=arr.length;
        ArrayList<Integer> goodElements = new ArrayList<>();
        ArrayList<Integer> windowArray = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(arr[i] <= b){
                goodElements.add(arr[i]);
            }
        }
        int goodCount=0;
        int badCount=0;
        int windowLength = goodElements.size();
        int minSwap=Integer.MAX_VALUE;
        for(int i=0;i<windowLength;i++){
            //windowArray.add(arr[i]);
            if(arr[i]<=b){
                goodCount++;
            } else { badCount++; }
        } //g=2 b=3
        //int badCount = windowLength - goodCount;
        minSwap = Math.min(minSwap, badCount);
        for(int start=1;start <= n-windowLength;start++){
            int end=start + windowLength - 1;

            if(arr[start] < b){ goodCount++; badCount--;} else { goodCount--; badCount++; }
            if(arr[end] < b) {goodCount++; badCount--; } else { goodCount--; badCount++; }
           // badCount = windowLength - goodCount;

            minSwap = Math.min(minSwap, badCount);
        }

        System.out.println("Min swap SW :"+minSwap);
    }
    static void minSwap_slidingWindow(int b, int[] arr) {
        int n = arr.length;

        // Count elements <= b
        int windowLength = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= b) {
                windowLength++;
            }
        }
        // Count bad elements in first window
        int badCount = 0;
        for (int i = 0; i < windowLength; i++) {
            if (arr[i] > b) {
                badCount++;
            }
        }
        int minSwap = badCount;
        // Slide the window
        for (int start = 1; start <= n - windowLength; start++) {
            int end = start + windowLength - 1;

            // element leaving window
            if (arr[start - 1] > b) {
                badCount--;
            }

            // element entering window
            if (arr[end] > b) {
                badCount++;
            }

            minSwap = Math.min(minSwap, badCount);
        }

        System.out.println("Min swap SW: " + minSwap);
    }

    public static void main(String[] args) {
        MinSwapSw sa = new MinSwapSw();
        int[] array1 = {-3,4,-2,5,3,-2,8,2,-1,4};
        int[] arr = {25,20,2,18,7,6,9,50,3};
        int[] cf_arr = {1, 12, 10, 3, 14, 10, 5};
        sa.minSwap_bf(8,cf_arr);
        System.out.println("Brute force TC: O(n * windowLength) ; SC: O(n * windowLength)");

        sa.minSwap_slidingWindow(10,arr);
        System.out.println("Brute force TC: O(n * windowLength) ; SC: O(n * windowLength)");
    }
}
