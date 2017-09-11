package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<List<Integer>> forest = new ArrayList<>();

        List<Integer> l0 = new ArrayList();
        l0.add(2);
        l0.add(3);
        l0.add(4);

        List<Integer> l1 = new ArrayList();
        l1.add(0);
        l1.add(0);
        l1.add(5);

        List<Integer> l2 = new ArrayList();
        l2.add(8);
        l2.add(7);
        l2.add(6);

        forest.add(l0);
        forest.add(l1);
        forest.add(l2);

        int h = forest.get(2).get(0);

        int test;
        test = cutOffTree(forest);

    }

    static class Element {
        int height;
        int row;
        int col;
        public Element(int h, int row, int col) {
            this.height = h;
            this.row = row;
            this.col = col;
        }
    }

    public static int cutOffTree(List<List<Integer>> forest) {
        if (forest.size() == 0 || forest.get(0).size() == 0) {
            return 0;
        }

        int m = forest.size();
        int n = forest.get(0).size();

        PriorityQueue<Element> minHeap = new PriorityQueue<>((a, b)->(a.height-b.height));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int h = forest.get(i).get(j);
                if (h == 0 || h == 1) {
                    continue;
                }
                Element e = new Element(h, i, j);
                minHeap.add(e);
            }
        }

        //start from (0,0)
        int curRow = 0;
        int curCol = 0;
        int res = 0;
        boolean[][] visited = new boolean[m][n];
        while (!minHeap.isEmpty()) {
            Element target = minHeap.poll();
            visited[curRow][curCol] = true;
            int steps = isReachable(visited, 0, curRow, curCol, target.row, target.col, forest);
            visited[curRow][curCol] = false;
            if (steps == -1) {
                return -1;
            } else {
                forest.get(target.row).set(target.col, 1);
                curRow = target.row;
                curCol = target.col;
                res += steps;
            }
        }
        return res;
    }


    static int isReachable(boolean[][] visited, int steps, int curRow, int curCol, int targetRow, int targetCol, List<List<Integer>> forest) {
        if (curRow == targetRow && curCol == targetCol) {
            return steps;
        }
        int row;
        int col;

        //go left
        row = curRow;
        col = curCol-1;

        int res = Integer.MAX_VALUE;
        if (col >= 0) {
            if (!visited[row][col]  && 0 != forest.get(row).get(col)) {
                visited[row][col] = true;
                int val = isReachable(visited, 1+steps, row, col, targetRow, targetCol,forest);
                visited[row][col] = false;
                if (val != -1) {
                    res = Math.min(res, val);
                }
            }
        }

        //go right
        row = curRow;
        col = curCol+1;
        if (col < forest.get(0).size()) {
            if (!visited[row][col]  && 0 != forest.get(row).get(col)) {
                visited[row][col] = true;
                int val = isReachable(visited, 1+steps, row, col, targetRow, targetCol,forest);
                visited[row][col] = false;
                if (val != -1) {
                    res = Math.min(res, val);
                }
            }
        }

        //go up
        row = curRow-1;
        col = curCol;
        if (row >= 0) {
            if (!visited[row][col]  && 0 != forest.get(row).get(col)) {
                visited[row][col] = true;
                int val = isReachable(visited, 1+steps, row, col, targetRow, targetCol,forest);
                visited[row][col] = false;
                if (val != -1) {
                    res = Math.min(res, val);
                }
            }
        }

        //go down
        row = curRow+1;
        col = curCol;
        if (row < forest.size()) {
            if (!visited[row][col]  && 0 != forest.get(row).get(col)) {
                visited[row][col] = true;
                int val = isReachable(visited, 1+steps, row, col, targetRow, targetCol,forest);
                visited[row][col] = false;
                if (val != -1) {
                    res = Math.min(res, val);
                }
            }
        }

        if (res == Integer.MAX_VALUE) {
            return -1;
        } else {
            return res;
        }
    }
}
