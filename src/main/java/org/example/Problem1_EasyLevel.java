package org.example;

public class Problem1_EasyLevel {

    public static void main(String[] args) {

        /**
         * Problem Statement:
         *      You are given an array of integers and a number k. Find the maximum sum of any contiguous subarray of size k.
         *
         * 🔍 Example:
         * Input: arr = [2, 1, 5, 1, 3, 2], k = 3
         *
         * Output: 9
         *
         * Explanation: Maximum sum of subarray of size 3 is 5+1+3 = 9
         */

        System.out.println("Problem 1 - Easy Level");

        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;

        int maxVal = 0;
        int maxWindowVal = 0;

        /**
         * Brute-force style with a reset loop
         * -----------------------------------
         *  Issues:
         * Every time a window completes (counterVal > k), it resets and goes back i -= 2. So it reprocesses overlapping elements again and again.
         *
         * It does not use the sliding window technique properly (sliding by one element), instead it rebuilds every window from scratch.
         *
         * ⏱️ Time Complexity:
         * Worst Case: O(n * k)
         * Because for each window, you're summing up to k elements repeatedly.
         *
         * 🧠 Space Complexity:
         * O(1) — No extra space used.
         */

//        int counterVal = 1;
//
//        for(int i=0;i< arr.length;i++){
//             if(counterVal <= k){
//                 maxWindowVal += arr[i];
//                 counterVal++;
//             }else{
//                 maxVal = Math.max(maxVal,maxWindowVal);
//                 counterVal = 1;
//                 maxWindowVal = 0;
//                 i -=2;
//             }
//        }

        /**
         * Optimized Sliding Window Code
         * -----------------------------
         * <p>
         * Compute the first window sum of size k.
         * Then slide the window by 1 element:
         * Subtract the first element of the previous window
         * Add the new incoming element
         * Keep updating the maxSum.
         * </p>
         *
         * Time Complexity: O(n)
         * Because you're visiting each element only once, and doing constant-time operations (add & subtract) per iteration.
         *
         * 🧠 Space Complexity:
         * O(1) — Only a few variables are used.
         *
         */

        for(int i=0;i<k;i++){
            maxVal+=arr[i];
        }
        maxWindowVal = maxVal;
        for(int j=k;j< arr.length;j++){
            maxWindowVal += arr[j]-arr[j-k];
            maxVal = Math.max(maxVal,maxWindowVal);
        }

        System.out.println("The maximum value is : "+maxVal);
    }
}