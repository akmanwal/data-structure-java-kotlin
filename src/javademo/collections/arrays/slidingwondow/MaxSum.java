package javademo.collections.arrays.slidingwondow;

/**
 * Given an array of integers arr[] and an integer k, find the maximum possible sum among all contiguous subarrays of size exactly k.
 * A subarray is a sequence of consecutive elements from the original array.
 * Return the maximum sum that can be obtained from any such subarray of length k.
 */
public class MaxSum {

    public static void main(String[] args) {

    }

    void method1() {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        // output: 9
        int maxSum = 0;

        for (int i = 0; i <= arr.length - k; i++) {

            int sum = 0;
            for (int j = i; j < k + i; j++) {
                sum = sum + arr[j];
            }

            maxSum = Math.max(sum, maxSum);
        }

        System.out.println(maxSum);
    }
}
