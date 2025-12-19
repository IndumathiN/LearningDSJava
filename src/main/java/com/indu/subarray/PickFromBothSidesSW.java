package com.indu.subarray;

public class PickFromBothSidesSW {
    static int maxSumPick_BF(int[] A, int B) {
        int n = A.length;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i <= B; i++) {
            int sum = 0;
            // pick i elements from left
            for (int l = 0; l < i; l++) {
                sum += A[l];
            }
            // pick B-i elements from right
            for (int r = 0; r < B - i; r++) {
                sum += A[n - 1 - r];
            }
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
    static int maxSumPick_prefixSum(int[] A, int B) {
        int n = A.length;
        // prefix sum
        int[] pref = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + A[i];
        }
        // suffix sum
        int[] suff = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suff[n - i] = suff[n - i - 1] + A[i];
        }
        int maxSum = Integer.MIN_VALUE;
        // try all combinations
        for (int i = 0; i <= B; i++) {
            int leftSum = pref[i];          // sum of i left elements
            int rightSum = suff[B - i];     // sum of B-i right elements
            maxSum = Math.max(maxSum, leftSum + rightSum);
        }
        return maxSum;
    }
    static int maxSumPick_slidingWindow(int[] A, int B) {
        int N = A.length;

        // Step 1: sum of first B elements (all from left)
        int currentSum = 0;
        for (int i = 0; i < B; i++) {
            currentSum += A[i];
        }

        int maxSum = currentSum;

        // Step 2: slide window: remove from left, add from right
        for (int i = 1; i <= B; i++) {
            currentSum = currentSum - A[B - i] + A[N - i];
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }


    public static void main(String[] args) {
        PickFromBothSidesSW pick = new PickFromBothSidesSW();
        int[] array1 = {5,-2,3,1,2};

        int maxSum_bf=pick.maxSumPick_BF(array1,3);
        System.out.println("Brute force TC: O(B^2) ; SC: O(1) "+ maxSum_bf);

        int maxSum_cf=pick.maxSumPick_prefixSum(array1,3);
        System.out.println("Prefix Sum TC: O(N) ; SC: O(N) "+ maxSum_cf);

        int maxSum_sw=pick.maxSumPick_slidingWindow(array1,3);
        System.out.println("Prefix Sum TC: O(B) ; SC: O(1) "+ maxSum_sw);
    }
}
