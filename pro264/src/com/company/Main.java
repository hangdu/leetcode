package com.company;

import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int test;
        test = nthUglyNumber(10);
    }

    public static int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        if (n == 3) {
            return 3;
        }

        int[] res = new int[n];
        res[0] = 1;
        res[1] = 2;
        res[2] = 3;

        //1, 2, 3, 4, 5, 6, 8, 9, 10, 12, ...
        int index = 3;
        int[] pointer = new int[3];
        pointer[0] = 1;
        pointer[1] = 1;
        pointer[2] = 0;

        int[] nums = new int[3];

        nums[0] = 2*res[pointer[0]];
        nums[1] = 3*res[pointer[1]];
        nums[2] = 5*res[pointer[2]];
        while(index < n) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = 0; i< 3; i++) {
                if (nums[i] < min) {
                    min = nums[i];
                    minIndex = i;
                }
            }

            if (min != res[index-1]) {
                res[index] = min;
                index++;
            }
            pointer[minIndex]++;
            if (minIndex == 0) {
                nums[0] = 2 * res[pointer[0]];
            } else if (minIndex == 1) {
                nums[1] = 3 * res[pointer[1]];
            } else {
                nums[2] = 5 * res[pointer[2]];
            }
        }
        return res[n-1];

    }
}
