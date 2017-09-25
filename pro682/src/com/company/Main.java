package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public int calPoints(String[] ops) {
        if (ops.length == 0) {
            return 0;
        }

        if (ops.length == 1) {
            return Integer.valueOf(ops[0]);
        }

        List<Integer> list = new ArrayList();

        int sum = 0;
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("+")) {
                int cur = list.get(list.size()-1) + list.get(list.size()-2);
                sum += cur;
                list.add(cur);
            } else if (ops[i].equals("D")) {
                int cur = 2 * list.get(list.size()-1);
                sum += cur;
                list.add(cur);
            } else if (ops[i].equals("C")) {
                sum -= list.get(list.size()-1);
                list.remove(list.size()-1);
            } else {
                int cur = Integer.valueOf(ops[i]);
                sum += cur;
                list.add(cur);
            }
        }
        return sum;
    }
}
