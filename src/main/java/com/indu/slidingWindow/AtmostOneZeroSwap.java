package com.indu.slidingWindow;

public class AtmostOneZeroSwap {
    static int swapatMost1Zero(int[] arr) {
        int countOnes=0;
        int start=0;
        int totalOnes = 0;
        int windowLength=0;
        int zeroCount=0;
        //count total ones in the array //edge case
        for (int num : arr) {
            if (num == 1) totalOnes++;
        }

        for(int end=0;end<arr.length;end++){
            if(arr[end]==0){

                zeroCount=zeroCount+1;
                while(zeroCount > 1){
                    if(arr[start]==0){
                        zeroCount=zeroCount-1;
                    }
                    start=start+1;
                }
            }
            windowLength=end-start+1;
            countOnes=Math.max(windowLength,countOnes);
        }
        return Math.min(countOnes, totalOnes);
    }

    public static void main(String[] args) {
        AtmostOneZeroSwap fw = new AtmostOneZeroSwap();
        int[] array1 = {1, 1, 1, 0, 1, 1, 1, 0, 1};
        int[] array2 = {1,1,1,0,0,0};
        int[] array3 = {1,1,1,0,0,0,1,1,1,1,0};
        int[] array4 ={0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int countConones = fw.swapatMost1Zero(array1);
        System.out.println("Max 1's after k flips is " + countConones);
    }
}
