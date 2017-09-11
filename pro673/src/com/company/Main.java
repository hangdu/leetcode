package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
	// write your code here
        int[] nums = {2,2,2,2,2};
        int test;
        test = findNumberOfLIS(nums);
    }


    public static int findNumberOfLIS(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        List<Integer> list = new ArrayList();
        int[] res = {0, 0};
        //backTracking
        helper(nums, 0, list, res);
        return res[1];
    }

    static void helper(int[] nums, int start, List<Integer> list, int[] res) {
        if (start == nums.length) {
            int size = list.size();
            if (size > res[0]) {
                res[0] = size;
                res[1] = 1;
            } else if (size == res[0]) {
                res[1]++;
            }
            return;
        }

        if (list.size() == 0) {
            //first case:
            list.add(nums[start]);
            helper(nums, start+1, list, res);
            list.remove(list.size()-1);
            //second case
            helper(nums, start+1, list, res);
            return;
        }

        int temp = list.get(list.size()-1);
        if (nums[start] > temp) {
            //two choice
            //first case:
            list.add(nums[start]);
            helper(nums, start+1, list, res);
            list.remove(list.size()-1);
            //second case
            helper(nums, start+1, list, res);
        } else {
            helper(nums, start+1, list, res);
        }
    }
}
