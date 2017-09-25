package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String test;
        test = nextClosestTime("13:55");
    }

    public static String nextClosestTime(String time) {
        //time length is 5
        int[] array = new int[4];
        int maxNumber = 0;
        int minNumber = Integer.MAX_VALUE;
        array[0] = time.charAt(0) - '0';
        array[1] = time.charAt(1) - '0';
        array[2] = time.charAt(3) - '0';
        array[3] = time.charAt(4) - '0';
        for (int i = 0; i < 4; i++) {
            if (array[i] > maxNumber) {
                maxNumber = array[i];
            }
            if (array[i] < minNumber) {
                minNumber = array[i];
            }
        }



        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (j == i) {
                    continue;
                }

                if (array[j] > array[i]) {
                    if (map.containsKey(array[i])) {
                        int val = map.get(array[i]);
                        if (array[j] < val) {
                            map.put(array[i], array[j]);
                        }
                    } else {
                        map.put(array[i], array[j]);
                    }
                }
            }
        }
        if (array[3] != maxNumber) {
            return time.substring(0, 4) + map.get(array[3]);
        }

        //check the third number
        if (map.containsKey(array[2]) && map.get(array[2]) <= 5) {
            return time.substring(0, 3) + map.get(array[2]) + minNumber;
        }

        //check the second number
        if (map.containsKey(array[1])) {
            if (array[0] == 0 || array[0] == 1) {
                return time.substring(0, 1) + map.get(array[1]) + ":" + minNumber + minNumber;
            } else {
                if (map.get(array[1]) < 4) {
                    return time.substring(0, 1) + map.get(array[1]) + ":" + minNumber + minNumber;
                }
            }
        }

        //check the first number
        if (map.containsKey(array[0])) {
            int val = map.get(array[0]);
            if (val * 10 + array[1] < 24) {
                return map.get(array[0]) + minNumber + ":" + minNumber + minNumber;
            }
        }

        //else
        return "" + minNumber + minNumber + ":" + minNumber + minNumber;
    }
}
