package com.indu.concepts;

import com.indu.subarray.SlidingWindow;

public class CountingTriplets {
    static int solve_bf(int[] arr) {
        int count=0;
        int n=arr.length;
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                if(arr[j] > arr[i]) {
                    for (int k = j + 1; k < n; k++) {
                        if(arr[k] > arr[j]) {
                            System.out.println("["+arr[i] +","+arr[j]+","+arr[k]+"]");
                            count=count+1;
                        }
                    }
                }
            }
        }
        return count;
    }

    static int solve_n2(int[] arr) {
        int count=0;
        int n=arr.length;

            for(int j=1;j<n-1;j++){ //fix the middle element
               int leftCount=0; //get count of elements < j from LHS
               int rightCount=0; //get count of elements > j from RHS
               for(int i=0 ;i<j;i++){
                   if(arr[i] < arr[j]){
                       leftCount=leftCount+1;
                   }
               }
                for(int k=j+1 ;k<n;k++){
                    if(arr[k] > arr[j]){
                        rightCount=rightCount+1;
                    }
                }
                count=count+(leftCount*rightCount);
            }

        return count;
    }

    public static void main(String[] args) {
        CountingTriplets sa = new CountingTriplets();
        //int[] array1 = {3,6,9,12,16,11};
        int[] array1 = {1,2,4,3};
        int countTriplets=sa.solve_n2(array1);
        System.out.println(countTriplets);
    }
}
