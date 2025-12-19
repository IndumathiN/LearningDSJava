package com.indu.subarray;

public class ClosestMinMaxSA {

    static int closestMinMaxSA_carryForward(int[] arr) {
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // Step 1: Find min and max
        for (int i = 0; i < n; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        // If all elements are same
        if (min == max) return 1;
        int minIndex = -1;
        int maxIndex = -1;
        int ans = n;
        // Step 2: Find closest subarray
        for (int i = 0; i < n; i++) {
            if (arr[i] == min) {
                minIndex = i;
                if (maxIndex != -1) {
                    ans = Math.min(ans, i - maxIndex + 1);
                }
            }
            if (arr[i] == max) {
                maxIndex = i;
                if (minIndex != -1) {
                    ans = Math.min(ans, i - minIndex + 1);
                }
            }
        }

        return ans;
    }


    static int closestMinMaxSA_BruteForce(int[] arr) {
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // Step 1: Find min and max
        for (int i = 0; i < n; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        int ans = Integer.MAX_VALUE;
        // Step 2: Check all subarrays
        for (int i = 0; i < n; i++) {
            boolean hasMin = false;
            boolean hasMax = false;
            for (int j = i; j < n; j++) {
                if (arr[j] == min) hasMin = true;
                if (arr[j] == max) hasMax = true;
                if (hasMin && hasMax) {
                    ans = Math.min(ans, j - i + 1);
                    break; // shortest subarray from i
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr={2, 6, 1, 6, 9, 1};
        int[] cf_arr={1,2,3,1,3,4,6,4,6,3};
        ClosestMinMaxSA sa=new ClosestMinMaxSA();
        int bf_length= sa.closestMinMaxSA_BruteForce(arr);

        int cf_length=sa.closestMinMaxSA_carryForward(cf_arr);
        System.out.println("Closest MinMAx Subarray length(Brute force): "+bf_length);
        System.out.println("Brute force TC :O(N)+O(N^2)= O(N^2) taking higher order of N \n SC: O(1)");
        System.out.println("Closest MinMAx Subarray length(carry forward): "+cf_length);
        System.out.println("Brute force TC :O(N) \n SC: O(1)");
        // print output
    }
}
