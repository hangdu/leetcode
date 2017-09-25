package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

//         [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .
        int[] p0 = {2,9,10};
        int[] p1 = {3,7,15};
        int[] p2 = {5,12,12};
        int[] p3 = {15,20,10};
        int[] p4 = {19,24,8};

        int[][] building = new int[5][3];
        building[0] = p0;
        building[1] = p1;
        building[2] = p2;
        building[3] = p3;
        building[4] = p4;

        List<int[]> res;
        res = getSkyline(building);

    }


    public static List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for(int[] b:buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }
        Collections.sort(height, (a, b) -> {
            if(a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);
        int prev = 0;
        for(int[] h:height) {
            if(h[1] < 0) {
                pq.offer(-h[1]);
            } else {
                pq.remove(h[1]);
            }
            int cur = pq.peek();
            if(prev != cur) {
                result.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        return result;
    }
}
