package com.company;

import java.util.ArrayList;
import java.util.List;

public class ZigzagIterator {
    int index;
    List<Integer> v1;
    List<Integer> v2;
    int index1;
    int index2;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public int next() {
        if (hasNext()) {
            int res;
            if (index1 == v1.size()) {
                res = v2.get(index2);
                index2++;
                index++;
                return res;
            } else if (index2 == v2.size()) {
                res = v1.get(index1);
                index1++;
                index++;
                return res;
            } else {
                if (index % 2 == 0) {
                    res = v1.get(index1);
                    index1++;
                    index++;
                    return res;
                } else {
                    res = v2.get(index2);
                    index2++;
                    index++;
                    return res;
                }
            }
        } else {
            return -1;
        }

    }

    public boolean hasNext() {
        return index < v1.size() + v2.size();
    }
}
