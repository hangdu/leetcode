package com.company;

import java.util.Arrays;

public class Main {
    //Actually this code is for problem 275: H-Index II

    public static void main(String[] args) {
	// write your code here
        int[] nums = {11, 15};
        int test;
        test = hIndex(nums);
    }

    static public int hIndex(int[] citations) {
        //The maximum result is citations.length
        if (citations.length == 0) {
            return 0;
        }

        if (citations.length == 1) {
            if (citations[0] == 0) {
                return 0;
            }
            return 1;
        }

//        Arrays.sort(citations);
        //try binary search
        int start = 1;
        int end = citations.length;
        int res = 0;
        while (start <= end) {
            int mid =start + (end-start)/2;
            //check whether there are mid elements which are at least mid
            //And check the rest of elements <= mid
            int index = citations.length - mid + 1;
            index--;
            if (citations[index] >= mid) {
                if (index == 0) {
                    return mid;
                }

                if (citations[index-1] <= mid) {
                    res = mid;
                }
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return res;
    }
}
