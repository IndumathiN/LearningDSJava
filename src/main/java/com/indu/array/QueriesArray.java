package com.indu.array;

import java.util.Arrays;

public class QueriesArray {
    static int[] queryStartValue_bf(int k,int arr[][]){
        int[] output=new int[k];
        int rows=arr.length;

        for(int i=0;i<rows;i++){
            int start=arr[i][0];
            int value=arr[i][1];
            for(int j=start;j<k;j++){
                output[j]+=value;
            }
        }
        return output;
    }
    static int[] queryStartEndValue_bf(int k,int arr[][]){
        int[] output=new int[k];
        int rows=arr.length;

        for(int i=0;i<rows;i++){
            int start=arr[i][0];
            int end=arr[i][1];
            int value=arr[i][2];
            for(int j=start;j<=end;j++){
                output[j]+=value;
            }
        }
        return output;
    }
    static int[] queryStartValue_optimised(int k,int arr[][]){
        int[] output=new int[k];
        int rows=arr.length;

        for(int i=0;i<rows;i++){
            int start=arr[i][0];
            int value=arr[i][1];
            output[start]+=value;
        }

        for (int i = 1; i < k; i++) {
            output[i] += output[i - 1];
        }

        return output;
    }
    static int[] queryStartEndValue_optimised(int k,int arr[][]){
        int[] output=new int[k];
        int rows=arr.length;

        for(int i=0;i<rows;i++){
            int start=arr[i][0];
            int end=arr[i][1];
            int value=arr[i][2];

            output[start]+=value;
            if(k > end+1) {
                output[end + 1] -= value;
            }
        }

        for (int i = 1; i < k; i++) {
            output[i] += output[i - 1];
        }

        return output;
    }
    public static void main(String[] args) {
        QueriesArray qa = new QueriesArray();
        int[][] arr = {{1,3},{4,-2},{3,1}};
       // qa.queryStartValue(7,arr);
        int[] qaIndVal = qa.queryStartValue_bf(7,arr);
        System.out.println("Queries array with (i,n) Brute force: " + Arrays.toString(qaIndVal));

        int[] qaIndVal_opt = qa.queryStartValue_optimised(7,arr);
        System.out.println("Queries array with (i,n) optimised :" + Arrays.toString(qaIndVal_opt));

        int[][] arr2={{1,3,2},{2,5,3},{2,4,1}};
        int[][] arr3={{1,3,2},{2,5,3},{2,4,-1}};
        int[] qaIndEndVal_bf = qa.queryStartEndValue_bf(6,arr3);
        System.out.println("Queries array with (s,e,n) bf :" + Arrays.toString(qaIndEndVal_bf));


        int[] qaIndEndVal_opt = qa.queryStartEndValue_optimised(6,arr3);
        System.out.println("Queries array with (s,e,n) opt :" + Arrays.toString(qaIndEndVal_opt));
    }
}
