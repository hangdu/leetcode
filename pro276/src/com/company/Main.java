package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int test;
        test = numWays(2,1);
    }


    static public int numWays(int n, int k) {
        if (k == 0 || n == 0) {
            return 0;
        }

        if (n == 1) {
            return k;
        }
        return k * helper(n, k, 1, false);
    }

    static int helper(int n, int k, int start, boolean sameAsbefore) {
        if (start == n-1) {
            if (sameAsbefore) {
                return k-1;
            } else {
                return k;
            }
        }


        if (sameAsbefore) {
            //k-1 choice
            int multi1 = k-1;
            int multi2 = helper(n, k, start+1, false);
            return multi1 * multi2;
        } else {
            //case1: choose same as before
            int res1 = helper(n, k, start+1, true);
            //case2: choose not same
            int multi1 = k-1;
            int multi2 = helper(n, k, start+1, false);
            return res1 + multi1 * multi2;
        }
    }

}
