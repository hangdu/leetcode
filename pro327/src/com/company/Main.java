package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums = {-2 , 5, -1};
        int test;
        test = countRangeSum(nums, -2, 2);
    }


    public static int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sums = new long[n + 1];
        for (int i = 0; i < n; ++i)
            sums[i + 1] = sums[i] + nums[i];
        return countWhileMergeSort(sums, 0, n + 1, lower, upper);
    }

    static private int countWhileMergeSort(long[] sums, int start, int end, int lower, int upper) {
        if (end - start <= 1) return 0;
        int mid = (start + end) / 2;

        int a = countWhileMergeSort(sums, start, mid, lower, upper);
        int b = countWhileMergeSort(sums, mid, end, lower, upper);
        int count = a + b;

        int j = mid, k = mid, t = mid;
        long[] cache = new long[end - start];
        for (int i = start, r = 0; i < mid; ++i, ++r) {
            while (k < end && sums[k] - sums[i] < lower) k++;
            while (j < end && sums[j] - sums[i] <= upper) j++;
            while (t < end && sums[t] < sums[i]) cache[r++] = sums[t++];
            cache[r] = sums[i];
            count += j - k;
        }
        System.arraycopy(cache, 0, sums, start, t - start);
        return count;
    }





//    public int countRangeSum(int[] nums, int lower, int upper) {
//        if (nums.length == 0) {
//            return 0;
//        }
//        int n = nums.length;
//        long[] subSum = new long[n];
//        subSum[0] = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            subSum[i] = subSum[i-1] + nums[i];
//        }
//
//        int res = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = i; j < n; j++) {
//                long a = 0;
//                if (i != 0) {
//                    a = subSum[i-1];
//                }
//
//                long sum = subSum[j] - a;
//                if (sum >= lower && sum <= upper) {
//                    res++;
//                }
//            }
//        }
//        return res;
//    }
}
