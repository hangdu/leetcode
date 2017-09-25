package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public int minTotalDistance(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        //find all the persons' position
        List<int[]> list = new ArrayList();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int[] pos = new int[] {i, j};
                    list.add(pos);
                }
            }
        }

        if (list.size()<=1) {
            return 0;
        }

        int[] Sx = new int[list.size()];
        int[] Sy = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            int[] pos = list.get(i);
            Sx[i] = pos[0];
            Sy[i] = pos[1];
        }

        Arrays.sort(Sx);
        Arrays.sort(Sy);

        int res = 0;
        res += getDis(Sx);
        res += getDis(Sy);
        return res;
    }

    int getDis(int[] array) {
        int start = 0;
        int end = array.length-1;
        int dis = 0;
        while (start < end) {
            int temp = array[end] - array[start];
            dis += temp;
            start++;
            end--;
        }
        return dis;
    }

//    public int minTotalDistance(int[][] grid) {
//        if (grid.length == 0 || grid[0].length == 0) {
//            return 0;
//        }
//        //find all the persons' position
//        List<int[]> list = new ArrayList();
//        int m = grid.length;
//        int n = grid[0].length;
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (grid[i][j] == 1) {
//                    int[] pos = new int[] {i, j};
//                    list.add(pos);
//                }
//            }
//        }
//
//        if (list.size()<=1) {
//            return 0;
//        }
//
//        int minDis = Integer.MAX_VALUE;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                int[] meetingPoint = new int[] {i, j};
//                int dis = 0;
//                for (int k = 0; k < list.size(); k++) {
//                    dis += getDis(meetingPoint, list.get(k));
//                }
//                minDis = Math.min(minDis, dis);
//            }
//        }
//        return  minDis;
//    }

//    int getDis(int[] p1,int[] p2) {
//        return Math.abs(p1[0]-p2[0]) + Math.abs(p1[1] - p2[1]);
//    }
}
