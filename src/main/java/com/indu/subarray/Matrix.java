package com.indu.subarray;

import java.util.Arrays;

public class Matrix {

    static void matrixRowSum(int[][] arr) {
        int rows= arr.length;
        int cols=arr[0].length;
        for(int i=0;i<rows;i++){
            int rowSum=0;
            for(int j=0;j<cols;j++){
                rowSum=rowSum+arr[i][j];
            }
            System.out.println("Row Sum at index "+i+" is "+rowSum);
        }
        System.out.println("TC: O(rows*cols): O(N^2) SC:O(1)");
    }

    static void matrixColumnSum(int[][] arr) {
        int rows= arr.length;
        int cols=arr[0].length;
        for(int j=0;j<cols;j++){
            int colSum=0;
            for(int i=0;i<rows;i++){
                colSum=colSum+arr[i][j];
            }
            System.out.println("Column Sum at index "+j+" is "+colSum);
        }
        System.out.println("TC: O(rows*cols): O(N^2) SC:O(1)");
    }

    static void matrixDiagnolSum(int[][] arr) {
        int rows= arr.length;
        int cols=arr[0].length;
        int diagnolSum=0;
        if(rows==cols){
            System.out.println("It's a square matrix");
            System.out.print("[");
            for(int i=0;i<rows;i++){
                diagnolSum+=arr[i][i];
//                for(int j=0;j<cols;j++){ //TC:O(N^2)
//                    if(i==j){
//                        diagnolSum+=arr[i][j];
//                    }
               // }
                System.out.print(arr[i][i]+", ");
            }
            System.out.print("]");
            System.out.println("Diagnol Sum is "+diagnolSum);
            System.out.println("Diagnol Sum:TC is O(N) SC:O(1)");
        }
        else {
            System.out.println("Not a square matrix");
        }
    }
    static void matrixAntiDiagnolSum(int[][] arr) {
        int rows= arr.length;
        int cols=arr[0].length;
        int antidiagnolSum=0;
        if(rows==cols){
            System.out.println("It's a square matrix");
            int j=cols-1;
            for(int i=0;i<rows;i++){
                    antidiagnolSum+=arr[i][j];  //improvements:[cols - 1 - i]
                    j--;
            }
            System.out.println("Anti-Diagnol Sum is "+antidiagnolSum);
            System.out.println("Anti-Diagnol Sum: TC:O(N) SC:O(1)");
        }
        else {
            System.out.println("Not a square matrix");
        }
    }
    static int[][] matrixTranspose(int[][] arr) {
        int rows= arr.length;
        int cols=arr[0].length;
        int[][] output = new int[cols][rows];
        for(int i=0;i<rows;i++){
                for(int j=0;j<cols;j++){
                    output[j][i]=arr[i][j];

                }
                System.out.println();
            }
        System.out.println("Transpose : TC: O(rows*cols): O(N^2) SC:O(1)");
         return output;
}

    public static void main(String[] args) {
        Matrix rowSum = new Matrix();
        int[][] array1 = {{1, 2, 3,4},{4,5,6,5},{7,8,9,10},{7,8,9,10}};
        //int[][] array1 = {{1, 2, 3},{4,5,6},{7,8,9}};
        rowSum.matrixRowSum(array1);
        rowSum.matrixColumnSum(array1);
        rowSum.matrixDiagnolSum(array1);
        rowSum.matrixAntiDiagnolSum(array1);
        int[][] transpose=rowSum.matrixTranspose(array1);
        System.out.println(Arrays.deepToString(transpose));

    }
}
