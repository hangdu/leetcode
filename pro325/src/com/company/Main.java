package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public int maxSubArrayLen(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        int[] subSum = new int[nums.length];
        subSum[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            subSum[i] = subSum[i-1] + nums[i];
        }
        int n = nums.length;
        //key is subSum
        //value is index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = n-1; i >= 0; i--) {
            map.put(subSum[i], i);
        }

        map.put(0, -1);

        int res = 0;
        for (int i = n-1; i>=0; i--) {
            int needed = subSum[i] - k;
            if (map.containsKey(needed)) {
                int start = map.get(needed);
                int len = i - start;
                res = Math.max(res, len);
            }
        }
        return res;
    }
}
