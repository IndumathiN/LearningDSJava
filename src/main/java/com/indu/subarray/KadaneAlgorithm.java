package com.indu.subarray;

public class KadaneAlgorithm {

    static int maxSASum_CarryForward(int[] arr) {
        int n = arr.length;
        int max=Integer.MIN_VALUE;
        for (int start = 0; start < n; start++) {
            int sum = 0; // reset for each start
            int tsaSum=0;
            for (int end = start; end < n; end++) {
                sum = sum + arr[end];   // carry forward
                System.out.println("Subarray [" + start + "," + end + "] Sum = " + sum);
                tsaSum=tsaSum+sum;
                max=Math.max(tsaSum,max);
            }

            System.out.println("Total subarray sum at index "+start +" is "+tsaSum);
            System.out.println();
        }
        return max;
    }
    static int totalMaxSASum(int[] arr) {
        int totalsaSum=0;
        int n= arr.length;
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            //[0,i]=i-0+1=i+1 [i,n-1]=n-1-i+1=n-i
            //contributionTime=(i+1)*(n-i)
            int contributionTime=(i+1)*(n-i);
            sum=contributionTime*arr[i];
            max=Math.max(sum,max);
            sum=0;
        }

        return max;
    }
    public static void main(String[] args) {
        KadaneAlgorithm sa= new KadaneAlgorithm();
        int[] array1 = {1,2,3,4};
        int[] arr = {2, 6, 1, 6, 9, 1};
        int[] cf_arr = {1, 2, 3, 1, 3, 4, 6, 4, 6, 3};


        int maxSaSum=sa.totalMaxSASum(array1);
        System.out.println("Max SubArray Sum using Kadane's algorithm is "+maxSaSum);

        int maxcfSum=sa.maxSASum_CarryForward(array1);
        System.out.println("Max SubArray Sum using CF is "+maxcfSum);
    }
}
