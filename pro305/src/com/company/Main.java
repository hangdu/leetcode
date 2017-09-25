package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }


    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] parent = new int[m*n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = -1;
        }

        Set<Integer> set = new HashSet();

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < positions.length; i++) {
            int row = positions[i][0];
            int col = positions[i][1];
            int temp = row * n + col;
            if (i == 0) {
                res.add(1);
                parent[temp] = temp;
                set.add(temp);
                continue;
            }

            if (parent[temp] == -1) {
                //explore 4 directions
                int nextRow;
                int nextCol;
                //up
                nextRow = row-1;
                nextCol = col;
                if (nextRow >= 0) {
                    int key = nextRow * n + nextCol;
                    if (parent[key] != -1) {
                        parent[temp] = key;
                    }
                }

                //down
                nextRow = row + 1;
                if (nextRow < m) {
                    int key = nextRow * n + nextCol;
                    if (parent[key] != -1) {
                        if (parent[temp] == -1) {
                            parent[temp] = key;
                        } else {
                            int parent1 = find(temp, parent);
                            int parent2 = find(key,parent);
                            if (parent1 != parent2) {
                                //union
                                parent[parent2] = parent1;
                                set.remove(parent2);
                            }
                        }
                    }
                }

                //left
                nextRow = row;
                nextCol = col-1;
                if (nextCol >= 0) {
                    int key = nextRow * n + nextCol;
                    if (parent[key] != -1) {
                        if (parent[temp] == -1) {
                            parent[temp] = key;
                        } else {
                            int parent1 = find(temp, parent);
                            int parent2 = find(key, parent);
                            if (parent1 != parent2) {
                                //union
                                parent[parent2] = parent1;
                                set.remove(parent2);
                            }
                        }
                    }
                }

                nextCol = col + 1;
                if (nextCol < n) {
                    int key = nextRow * n + nextCol;
                    if (parent[key] != -1) {
                        if (parent[temp] == -1) {
                            parent[temp] = key;
                        } else {
                            int parent1 = find(temp,parent);
                            int parent2 = find(key, parent);
                            if (parent1 != parent2) {
                                //union
                                parent[parent2] = parent1;
                                set.remove(parent2);
                            }
                        }
                    }
                }

                if (parent[temp] == -1) {
                    parent[temp] = temp;
                    set.add(temp);
                }
            }
            res.add(set.size());
        }
        return res;
    }

    int find(int val, int[] parent) {
        if (parent[val] == -1) {
            return -1;
        }

        if (parent[val] == val) {
            return val;
        }

        return find(parent[val], parent);
    }
}
