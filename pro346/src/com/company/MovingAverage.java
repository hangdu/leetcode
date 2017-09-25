package com.company;

public class MovingAverage {
    /** Initialize your data structure here. */
    int[] array;
    int sum;
    int end = -1;
    int count = 0;

    public MovingAverage(int size) {
        array = new int[size];
    }

    public double next(int val) {
        if (array.length == 1) {
            return val;
        }
        end++;
        if (count < array.length) {
            count++;
            array[end] = val;
            sum += val;
            return (double)sum / count;
        }

        if (end == array.length) {
            end = 0;
        }
        sum -= array[end];
        array[end] = val;
        sum += array[end];

        return (double)sum / count;
    }
}
