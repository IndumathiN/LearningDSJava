package com.indu.array;

import java.util.Arrays;

public class MissingNaturalNo {
    static int optimised(int arr[]){
        int num=0;
        int n=arr.length;
        //eg:[4,1,3,2]
        for(int i=0;i<n;i++){
            while (arr[i] != i+1 && arr[i]<=n){
                int temp=arr[i]; //4
                int swapIndex=arr[i]-1; //4-1 =3
                arr[i]=arr[swapIndex]; //arr[0]=3 (arr[3])
                arr[swapIndex]=temp;
            }
        }
        System.out.println(Arrays.toString(arr));
        return num;
    }
    public static void main(String[] args) {
        MissingNaturalNo naturalNo = new MissingNaturalNo();
        int[] arr={0,4,1,2,5};
        naturalNo.optimised(arr);
    }
}
