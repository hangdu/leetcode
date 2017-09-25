package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here\
        int[] nums = {4, 1, 8, 7};
        boolean test;
        test = judgePoint24(nums);
    }


    public static boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add((double)nums[i]);
        }

        return helper(list);
    }

    static boolean helper(List<Double> list) {
        double epsilon = 0.0000001;
        if (list.size() == 2) {
            List<Double> res = getResult(list.get(0), list.get(1));
            for (int i = 0; i < res.size();i++) {
                if (Math.abs(res.get(i)-24) < epsilon) {
                    return true;
                }
            }
            return false;
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if (j != i) {
                    List<Double> temp = new ArrayList<>();
                    for (int k = 0; k < list.size(); k++) {
                        if (k != i && k != j) {
                            temp.add(list.get(k));
                        }
                    }

                    List<Double> res = getResult(list.get(i), list.get(j));
                    for (int k = 0; k < res.size(); k++) {
                        temp.add(res.get(k));
                        boolean flag = helper(temp);
                        if (flag) {
                            return true;
                        }
                        temp.remove(temp.size()-1);
                    }
                }
            }
        }
        return false;
    }

    static List<Double> getResult(double a, double b) {
        double epsilon = 0.0000001;
        List<Double> list = new ArrayList<>();
        double res = a + b;
        list.add(res);
        res = a * b;
        list.add(res);
        res = a - b;
        list.add(res);
        res = b - a;
        list.add(res);
        if (Math.abs(b-0)>epsilon) {
            res = a / b;
            list.add(res);
        }
        if (Math.abs(a-0)>epsilon) {
            res = b / a;
            list.add(res);
        }
        return list;
    }
}
