package com.indu.subarray;

public class ProductSA {
    static int saLessThanK(int b,int[] arr) {
        int count=0;
        int n=arr.length;
        int product=1;
        for (int start = 0; start < n; start++) {
            int prod = 1; // reset for each start

            for (int end = start; end < n; end++) {
                prod = prod * arr[end];   // carry forward
                System.out.println("[" + start + "," + end + "] Product = " + prod);

                if(prod < b){
                    product=Math.max(product,prod);
                    count=count+1;
                }
            }

        }
        return count;
    }
    static int minSubArrayLen(int b,int[] arr) {
        int n = arr.length;

        int minLength=Integer.MAX_VALUE;

        for (int start = 0; start < n; start++) {
            int sum = 0; // reset for each start

            for (int end = start; end < n; end++) {
                sum = sum + arr[end];   // carry forward
                int saLength=end-start+1;
                System.out.println("Subarray [" + start + "," + end + "] Sum = " + sum+ " length "+saLength);
                if(sum >=b){
                    System.out.println("min "+minLength);
                    minLength=Math.min(minLength,saLength);
                }
            }

        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
    public static void main(String[] args) {
        ProductSA maxSAProduct= new ProductSA();

        int b=100;
        int[] array1 = {10,5,2,6};
        int count=maxSAProduct.saLessThanK(b,array1);
        System.out.println(count);

        int[] arr={1,1,1,1,1,1,1,1};
        int minLength=maxSAProduct.minSubArrayLen(11,arr);
        System.out.println("MinLength of SA "+minLength);
    }
}
