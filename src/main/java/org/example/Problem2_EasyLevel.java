package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2_EasyLevel {
    public static void main(String[] args) {

        /**
         * Problem Statement:
         * Given an array of integers and a number k, find the average of all contiguous subarrays of size k in the array.
         *
         * 🔍 Sample Input and Output:
         * Input:
         * arr = [1, 3, 2, 6, -1, 4, 1, 8, 2]
         * k = 5
         *
         * Output:
         * [2.2, 2.8, 2.4, 3.6, 4.4]
         *
         * Explanation:
         * The averages of subarrays of size 5 are:
         *
         * (1+3+2+6+(-1))/5 = 2.2
         *
         * (3+2+6+(-1)+4)/5 = 2.8
         *
         * (2+6+(-1)+4+1)/5 = 2.4
         *
         * (6+(-1)+4+1+8)/5 = 3.6
         *
         * ((-1)+4+1+8+2)/5 = 2.8
         */

        System.out.println("Problem 2 - Easy Level");

        int[] arr = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        int k = 5;

        /**
         * Functionality:
         * Computes average of all contiguous subarrays of size k.
         *
         * First manually computes sum of first k elements.
         *
         * Then slides the window forward by 1, maintaining the sum.
         *
         * ⏱️ Time Complexity: O(n)
         * First loop: O(k)
         *
         * Second loop: O(n - k)
         *
         * Overall: O(n), where n is the length of array.
         *
         * 🧠 Space Complexity: O(n)
         * You’re storing all averages in a List<Float> → O(n)
         *
         * ⚠️ Precision Note:
         * You used float, which may lose precision in certain cases compared to double.
         *
         * 🔧 Design/Structure:
         * Divides logic into two loops (manual + sliding).
         *
         * Works correctly, but is less scalable for generalized sliding window problems.
         *
         * No variable to represent sliding window start (windowStart).
         *
         * ✅ Pros:
         * Correct.
         *
         * Simple for fixed-sized average calculation.
         *
         * Uses sliding window optimization.
         *
         * ❌ Cons:
         * float → less precise.
         *
         * Two loops where one would suffice.
         *
         * Not reusable for more complex problems (e.g., variable window size).
         */

//        List<Float> avgList = new ArrayList<>();
//
//        float sum = 0;
//
//        for(int i = 0; i<k;i++){
//            sum += arr[i];
//        }
//
//        avgList.add(sum/k);
//
//        for(int j =k;j< arr.length;j++){
//            sum += arr[j] - arr[j-k];
//            avgList.add(sum/k);
//        }
//
//        System.out.println(" The Average List is : "+avgList);

        /**
         * Functionality:
         * General sliding window implementation.
         *
         * Single-pass approach with dynamic start (windowStart) and end (windowEnd).
         *
         * Calculates average when window size reaches k.
         *
         * ⏱️ Time Complexity: O(n)
         * Each element is added once and subtracted once → O(n)
         *
         * 🧠 Space Complexity: O(n)
         * double[] result stores all averages → O(n)
         *
         * 🎯 Precision:
         * Uses double for higher accuracy in decimal results.
         *
         * 🔧 Design/Structure:
         * Standardized sliding window structure with windowStart and windowEnd.
         *
         * Clean, scalable, and extendable (e.g., for max, min, count, etc.).
         *
         * Easily handles edge cases and variations.
         *
         * ✅ Pros:
         * High precision with double
         *
         * One loop, clean logic
         *
         * Reusable template for other problems
         *
         * Professional and interview-friendly structure
         *
         * ❌ Cons:
         * Slightly more verbose for this simple problem (but more scalable)
         */

        int n = arr.length;

        /**
         * Meaning of n - k + 1
         * 📌 Where:
         * n = total number of elements in the array
         *
         * k = size of the subarray (window)
         *
         * 🤔 Why n - k + 1?
         * Let’s understand with an example:
         *
         * Example:
         * java
         * Copy
         * Edit
         * arr = {1, 3, 2, 6, -1, 4, 1, 8, 2}
         * n = 9
         * k = 5
         * Now let’s find how many subarrays of size k = 5 exist:
         *
         * [1, 3, 2, 6, -1]
         *
         * [3, 2, 6, -1, 4]
         *
         * [2, 6, -1, 4, 1]
         *
         * [6, -1, 4, 1, 8]
         *
         * [-1, 4, 1, 8, 2]
         *
         * → Total = 5 subarrays
         *
         * 🧠 That’s n - k + 1 = 9 - 5 + 1 = 5
         *
         * 🔢 General Rule:
         * To find how many windows of size k fit in an array of size n, we calculate:
         *
         * ✅ Total Windows = n - k + 1
         *
         * Because:
         *
         * The first window starts at index 0
         *
         * The last window starts at index n - k
         */

        double[] result = new double[n - k + 1];
        double windowSum = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
            windowSum += arr[windowEnd];  // add new element

            if (windowEnd >= k - 1) {
                result[windowStart] = windowSum / k;
                windowSum -= arr[windowStart];  // remove leftmost element
                windowStart++;  // move window forward
            }
        }

        System.out.println(" The Average List is : "+ Arrays.toString(result));

    }
}
