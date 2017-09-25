package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] primes = {2,7,13,19};
        int test;
        test = nthSuperUglyNumber(10, primes);
    }


    public static int nthSuperUglyNumber(int n, int[] primes) {
        //int[] 3 elements
        //The first element is the base number
        //The second number is the index for result
        //The third one is the compared one

        List<Integer> list = new ArrayList();
        list.add(1);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b)->((int[])a)[2] - ((int[])b)[2]);
        for (int i = 0; i <primes.length; i++) {
            int[] temp = new int[] {primes[i], 0, primes[i]};
            minHeap.add(temp);
        }

        while (list.size() != n) {
            int[] temp = minHeap.poll();
            if (temp[2] != list.get(list.size()-1)) {
                list.add(temp[2]);
            }

            temp[1]++;
            temp[2] = temp[0] * list.get(temp[1]);
            minHeap.add(temp);
        }
        int res = list.get(n-1);
        return res;
    }
}
