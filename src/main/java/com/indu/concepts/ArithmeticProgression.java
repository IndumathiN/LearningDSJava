package com.indu.concepts;

import java.sql.SQLOutput;
import java.util.Arrays;

public class ArithmeticProgression {
    public static int findArrayIsAP(int[] arr) {

        int n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[j] < arr[i]){
                    System.out.println("["+i+","+j+"]"+"= ["+arr[i]+","+arr[j]+"]");
                    int temp=arr[i]; //i=3
                    arr[i]=arr[j]; //arr[0]=1
                    arr[j]=temp;  //arr[2]=temp
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        int diff = arr[1] - arr[0];
        for (int i = 2; i < n; i++) {
            if (arr[i] - arr[i - 1] != diff) {
                return 0;
            }
        }
        return 1;
    }
    public boolean containsDuplicate(int[] nums) {
        int n=nums.length;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[j] == nums[i]){

                    return true;

                }}}
        return false;
    }
    public static int[] moveZeros(int[] arr) {
        int pos = 0; // position for next non-zero

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[pos];
                arr[pos] = arr[i];
                arr[i] = temp;
                pos++;
            }
        }
        return arr;
    }

    public static int[] moveZeros_nestedLoops(int[] arr) {
        int n=arr.length;
        //int[] output=new int[n];
        for(int i=0; i<n; i++){
            for(int j=i+1;j<n;j++){
                if(arr[i] == 0){ System.out.println("["+i+","+j+"]"+"= ["+arr[i]+","+arr[j]+"]");
                    int temp=arr[j]; //temp=1
                    arr[j]=arr[i]; //arr[1]=0
                    arr[i]=temp;   //arr[0]=1
                }
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        ArithmeticProgression ap = new ArithmeticProgression();
        int[] arr={3,5,1};
        int[] arr1={1,4,2};
        int isAp= ap.findArrayIsAP(arr);
        System.out.println("the given array "+Arrays.toString(arr)+" is AP? : "+isAp);
        System.out.println("the given array is "+Arrays.toString(arr1)+" AP? : "+ap.findArrayIsAP(arr1));

        int[] arr3={1,2,3,1};
        int[] nums = {1,1,1,3,3,4,3,2,4,2};
        boolean dup =ap.containsDuplicate(arr3);
        System.out.println("the given "+Arrays.toString(arr)+"array has duplicates? "+dup);

        int[] arr4={0,1,0,3,12};
        System.out.println(Arrays.toString(ap.moveZeros(arr4)));
    }
}
