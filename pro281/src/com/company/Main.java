package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<Integer> v1 = new ArrayList();
        v1.add(1);
        v1.add(2);

        List<Integer> v2 = new ArrayList();
        v2.add(3);
        v2.add(4);
        v2.add(5);
        v2.add(7);


        ZigzagIterator iter = new ZigzagIterator(v1, v2);
        int test = 0;
        while(iter.hasNext()) {
            test = iter.next();
        }

    }
}
