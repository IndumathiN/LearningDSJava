package com.indu.concepts;

import com.indu.slidingWindow.FlipSW;

import javax.sound.midi.Soundbank;

public class MooreVotingAlgorithm {
    static int repeatedNo_nBy2(int[] arr) {
        int count=0;
        int cand=0;
        int n =arr.length;
        for(int i=0;i<n;i++){
            if(count == 0){
                cand=arr[i];
                count=count+1;
            } else if (arr[i] != cand) {
                count=count-1;
                
            } else if (arr[i] == cand) {
                count=count+1;

            }
        }
        System.out.println("Candidate :"+cand);
        count = 0;
        for (int num : arr) {
            if (num == cand) {
                count=count+1;
            }
        }
        if (count > n / 2) return cand;

        return -1;
    }
    static int repeatedNo_nBy3(int[] arr) {
        int n = arr.length;

        // Step 1: Find potential candidates
        int cand1 = 0, cand2 = 0;
        int count1 = 0, count2 = 0;

        for (int num : arr) {
            if (num == cand1) {
                count1++;
            } else if (num == cand2) {
                count2++;
            } else if (count1 == 0) {
                cand1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                cand2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        System.out.println("Candidates1: "+cand1+" cand2: "+ cand2);
        // Step 2: Verify actual counts
        count1 = 0;
        count2 = 0;

        for (int num : arr) {
            if (num == cand1) count1++;
            else if (num == cand2) count2++;
        }

        if (count1 > n / 3) return cand1;
        if (count2 > n / 3) return cand2;

        return -1;
    }
    public static void main(String[] args) {
        MooreVotingAlgorithm mva = new MooreVotingAlgorithm();
        int[] array={1,2,3,1,1};
        int[] arr1={3,3,4,2,4,4,2,4,4};
        int count=mva.repeatedNo_nBy3(arr1);
        System.out.println("Max repeated element in the array with N/3 is "+count);

        int count_nby2=mva.repeatedNo_nBy2(array);
        System.out.println("Max repeated element in the array with N/2 is "+count_nby2);
    }
}
