package com.company;

import java.util.*;

public class Main {
    //tips to prevent time limited error
    //1. For BFS algorithm, there are two implementation. The first one is to recursively call some function. The second one is to use Queue. The second one is faster.
    //Focus about how to record level information
    //2. Here I create Element class. It is better to use int[] array than to create a new class.

    static int[][] dirs = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) {
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
                //This one is wrong
//                if (i == 0 || j == 0) {
//                    continue;
//                }
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

        while (!minHeap.isEmpty()) {
            Element target = minHeap.poll();
            int steps = isReachable(m, n, curRow, curCol, target.row, target.col, forest);
            if (steps == -1) {
                return -1;
            } else {
                curRow = target.row;
                curCol = target.col;
                res += steps;
            }
        }
        return res;
    }

    static int isReachable(int m, int n, int curRow, int curCol, int targetRow, int targetCol, List<List<Integer>> forest) {
        boolean[][] visited = new boolean[m][n];
        visited[curRow][curCol] = true;
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{curRow, curCol});

        int row;
        int col;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] temp = queue.poll();
                if (temp[0] == targetRow && temp[1] == targetCol) {
                    return level;
                }
                for (int[] dir : dirs) {
                    row = temp[0] + dir[0];
                    col = temp[1] + dir[1];
                    if (row >= 0 && row < m && col >= 0 && col < n && !visited[row][col] && forest.get(row).get(col) != 0) {
                        visited[row][col] = true;
                        queue.add(new int[] {row, col});
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
