package com.indu.session1;

public class PrimeNumber {

    public static String checkPrime(int n) {

        if (n <= 1) {
            return n + " is Not a Prime number";
        }
        /*Approach1
        * Time computation 10^8 iterations =1sec
        *
        * */
        for (int i = 2; i < n; i++) {
            /*Approach2 => i=sqrt(n) 10^10 iteration=10^(10-8)=10^2 =100s(computation time) */
//      for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return n + " is Not a Prime number";
            }
        }
        /*Approach2 */
//        for (int i = 2; i * i <= n; i++) {
//            if (n % i == 0) {
//                return n + " is Not a Prime number";
//            }
//        }



        return n + " is a Prime Number";
    }

    public static void main(String[] args) {
        int n = 9;
        System.out.println(checkPrime(n));  // print output
    }
}
