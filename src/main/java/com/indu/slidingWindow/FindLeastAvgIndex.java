package com.indu.slidingWindow;

public class FindLeastAvgIndex {

    static int solve_slidingWindow(int b,int[] arr) {

        int n=arr.length;
        if (n < b) return -1; //edge cases;
        int saSum=0;
        for(int i=0;i<b;i++){
            saSum+=arr[i];
        }
        int minSum=saSum;
        int leastIndex=0;

        for (int start = 1; start <= n - b; start++) {
            int end = start + b - 1; //1+3-1 =3
            saSum=saSum-arr[start-1]+arr[end];
            if(saSum<minSum){
                leastIndex=start;
                minSum=saSum;
            }
        }

        return leastIndex;
    }
    public static void main(String[] args) {
        FindLeastAvgIndex leastAvgIndex= new FindLeastAvgIndex();
        int[] array1 = {3, 7, 90, 20, 10, 50, 40};
        int[] array2={3, 7, 5, 20, -10, 0, 12};
        int index= leastAvgIndex.solve_slidingWindow(3,array1);
        System.out.println("Sliding Window TC: O(N) SC:O(1): "+index);

    }
}
