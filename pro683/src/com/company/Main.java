package com.company;

import java.util.TreeMap;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] flowers = {1,3,2};
        int test;
        test = kEmptySlots(flowers, 1);
    }
    //key is position   value is day
    public static int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < flowers.length; i++) {
            //ith day
            if (i == 0) {
                set.add(flowers[i]);
                continue;
            }

            int pos = flowers[i];
            Integer lower = set.lower(pos);
            if (lower != null) {
                if (pos - lower == k+1) {
                    return i+1;
                }
            }

            Integer higher = set.higher(pos);
            if (higher != null) {
                if (higher - pos == k+1) {
                    return i+1;
                }
            }

            set.add(flowers[i]);
        }
        return -1;
    }
}
