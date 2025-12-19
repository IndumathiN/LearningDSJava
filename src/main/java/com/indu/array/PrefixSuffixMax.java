package com.indu.array;

import java.util.Arrays;

public class PrefixSuffixMax {
    static int[] prefMax(int arr[]){
        int n= arr.length;
        int[] prefMax=new int[n];
        prefMax[0]=arr[0];
        for(int i=1;i<n;i++){
            prefMax[i]=Math.max(prefMax[i-1],arr[i]);
        }
        return prefMax;
    }
    static int[] suffixMax(int arr[]){
        int n= arr.length;
        int[] suffMax=new int[n];
        suffMax[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            suffMax[i]=Math.max(suffMax[i+1],arr[i]);
        }
        return suffMax;
    }
    public static void main(String[] args) {
        PrefixSuffixMax max= new PrefixSuffixMax();
        int[] arr={1,-6,3,2,8,7};
        int[] prefMax=max.prefMax(arr);
        System.out.println("Prefix Max array "+ Arrays.toString(prefMax));

        int[] arr1={3,10,6,7,0,2,-1};
        int[] suffMax=max.suffixMax(arr1);
        System.out.println("Suffix Max array "+ Arrays.toString(suffMax));
    }
}
