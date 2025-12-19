package com.indu.subarray;

public class FindLeastAvgIndex {
    static int solve_BruteForce(int b,int[] arr) {
        int minSum=Integer.MAX_VALUE;
        int leastIndex=0;
        int n=arr.length;
        for(int start=0; start<=n-b;start++){
            int sum=0;
            for(int end=start;end<start+b;end++){
                sum=sum+arr[end];
                System.out.println("[" + start + "," + end + "] = " + sum);
            }
            if(sum<minSum){
                leastIndex=start;
                minSum=sum;
            }

        }
        return leastIndex;
    }

    public static void main(String[] args) {
        FindLeastAvgIndex leastAvgIndex= new FindLeastAvgIndex();
        int[] array1 = {3, 7, 90, 20, 10, 50, 40};
        int[] array2={3, 7, 5, 20, -10, 0, 12};
        int index= leastAvgIndex.solve_BruteForce(3,array2);
        System.out.println("BruteForce : "+index);

    }
}
