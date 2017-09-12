package com.company;

public class Main {
    /*
    At first, I am solving this problem with backtracking which has limited time error. So it should be solved with dynamic programming.
    1.One possible solution: dp[i][j].  The subsequence must start with i and end with j
    2.Second possible solution:  dp[i][j]. The subsequence must end with j.
    (The problem is that: Since we just require the subsequence must end with j, we should use one dimension dp array rather than two dimensional.
    So it should be dp[j]. The meaning is that the subsequence must end with j.)
     */
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

        int n = nums.length;
        int[] len = new int[n];
        int[] count = new int[n];

        len[0] = 1;
        count[0] = 1;
        for (int i = 1; i < nums.length;i++) {
            //find len[i] and count[i]
            len[i] = 1;
            count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    int tempLen = len[j]+1;
                    int tempCount = count[j];

                    if (tempLen > len[i]) {
                        len[i] = tempLen;
                        count[i] = tempCount;
                    } else if (tempLen == len[i]) {
                        count[i] += tempCount;
                    }
                }
            }
        }

        int maxLen = len[0];
        for (int i = 1;  i < n; i++) {
            if (len[i] > maxLen) {
                maxLen = len[i];
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (len[i] == maxLen) {
                res += count[i];
            }
        }
        return res;
    }


//    public static int findNumberOfLIS(int[] nums) {
//        if (nums.length < 2) {
//            return nums.length;
//        }
//        List<Integer> list = new ArrayList();
//        int[] res = {0, 0};
//        //backTracking
//        helper(nums, 0, list, res);
//        return res[1];
//    }
//
//    static void helper(int[] nums, int start, List<Integer> list, int[] res) {
//        if (start == nums.length) {
//            int size = list.size();
//            if (size > res[0]) {
//                res[0] = size;
//                res[1] = 1;
//            } else if (size == res[0]) {
//                res[1]++;
//            }
//            return;
//        }
//
//        if (list.size() + nums.length - start < res[0]) {
//            return;
//        }
//
//        if (list.size() == 0) {
//            //first case:
//            list.add(nums[start]);
//            helper(nums, start+1, list, res);
//            list.remove(list.size()-1);
//            //second case
//            helper(nums, start+1, list, res);
//            return;
//        }
//
//        int temp = list.get(list.size()-1);
//        if (nums[start] > temp) {
//            //two choice
//            //first case:
//            list.add(nums[start]);
//            helper(nums, start+1, list, res);
//            list.remove(list.size()-1);
//            //second case
//            helper(nums, start+1, list, res);
//        } else {
//            helper(nums, start+1, list, res);
//        }
//    }
}
