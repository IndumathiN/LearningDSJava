package com.indu.subarray;

public class MaxProductSALC {
    static int maxProduct_CarryForward(int[] arr) {
        int n = arr.length;
        int maxProduct=Integer.MIN_VALUE;

        for (int start = 0; start < n; start++) {
            int product = 1; // reset for each start

            for (int end = start; end < n; end++) {
                product = product * arr[end];   // carry forward
                System.out.println("Subarray [" + start + "," + end + "] Sum = " + product);
                maxProduct=Math.max(maxProduct,product);
            }

        }
        return maxProduct;
    }
    public static void main(String[] args) {
        MaxProductSALC maxSAProduct = new MaxProductSALC();

//        int b=12;
        int[] array1 = {2,3,-2,4};
        int b = 1;
        int maxsum_pf = maxSAProduct.maxProduct_CarryForward(array1);
        System.out.println("MaxSA Product with CF is " + maxsum_pf);
    }
}
