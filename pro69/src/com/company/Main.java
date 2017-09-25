package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int test;
        test = mySqrt(17);
    }
    //binary search
    public static int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }

        long start = 1;
        long end = x / 2;
        long mid = 0;
        while (start <= end) {
            mid = start + (end - start)/2;
            long temp = mid * mid;
            if (temp == x) {
                return (int)mid;
            } else if (temp < x) {
                start = mid + 1;
            } else {
                end = mid-1;
            }
        }
        return (int)end;
    }
}
