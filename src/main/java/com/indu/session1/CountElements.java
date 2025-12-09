package com.indu.session1;

public class CountElements {

    int countOfElements(int arr[]) {
        int max = arr[0];
        // Find max element Time Complexity : N+N=2N =>O(N) Space Complexity: O(1)
        for (int i = 1; i < arr.length; i++) { // [1,N] =N-1+1=N
            max = Math.max(max, arr[i]);
        }
        // Count elements less than max
        int count = 0;
        for (int i = 0; i < arr.length; i++) { //[0,N-1]=N-1-0+1=N
            if (arr[i] < max) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        //list of no.Output: {2,5,1,4,0,1,3}
        //Time complexity: O(N^2) // Space complexity : O(1)
        int arr[] = {2, 5, 1, 4, 8, 0, 8, 1, 3, 8};

        CountElements obj = new CountElements();

        int result = obj.countOfElements(arr);
        System.out.println("Count = " + result);
    }
}
