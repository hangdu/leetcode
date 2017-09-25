package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[] prices = {1,3,5,2,10};
        int test;
        test = maxProfit(prices);
    }

    public static int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        int n = prices.length;
        int res = 0;
        int temp = 1;
        while (temp < n) {
            if (prices[temp] > prices[temp-1]) {
                //start to explore
                int end = find(prices, temp);
                int profit = prices[end] - prices[temp-1];
                res += profit;
                temp = end;
            }
            temp++;
        }
        return res;
    }

    static int find(int[] prices, int temp) {
        if (temp == prices.length-1) {
            return temp;
        }
        temp++;
        while (temp < prices.length) {
            if (prices[temp]>prices[temp-1]) {
                temp++;
            } else {
                return temp-1;
            }
        }
        return prices.length-1;
    }


//    public int maxProfit(int[] prices) {
//        if (prices.length <= 1) {
//            return 0;
//        }
//
//        int n = prices.length;
//        int[] buy = new int[n];
//        int[] sell = new int[n];
//        buy[0] = -1 * prices[0];
//        int res = 0;
//        for (int i = 1; i < n; i++) {
//            //find buy[i]
//            //find sell[i]
//            buy[i] = Integer.MIN_VALUE;
//            sell[i] = Integer.MIN_VALUE;
//            for (int j = 0; j < i; j++) {
//                int temp = sell[j] - prices[i];
//                buy[i] = Math.max(buy[i], temp);
//
//                temp = buy[j] + prices[i];
//                sell[i] = Math.max(sell[i], temp);
//            }
//            res = Math.max(res, sell[i]);
//
//        }
//        return res;
//
//    }
}
