package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String s = "test";
        String t = s.substring(4);
        List<String> test;
        test = generateAbbreviations("word");


    }


    public static List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        res.add(word);
        if (word.length() == 0) {
            return res;
        }

        if (word.length() == 1) {
            res.add("1");
            return res;
        }

        List<Integer> lastIndexList = new ArrayList<>();
        List<Integer> replaceNumList = new ArrayList<>();
        lastIndexList.add(-1);
        replaceNumList.add(0);


        for (int i = 0; i< word.length(); i++) {
            String temp = word.substring(0, i) + 1 + word.substring(i+1);
            res.add(temp);
            lastIndexList.add(i+1);
            replaceNumList.add(1);
        }

        int count = 2;
        while (count < word.length()) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                if (i == 0) {
                    //no char is replaced
                    String s = res.get(0);
                    for (int j = 0; j + count <= word.length(); j++) {
                        String temp = s.substring(0, j) + count + s.substring(j+count);
                        res.add(temp);
                        int len = String.valueOf(count).length();
                        lastIndexList.add(j+len);
                        replaceNumList.add(count);
                    }
                } else {
                    String s = res.get(i);
                    int tobeReplacedNum = count - replaceNumList.get(i);
                    int start = lastIndexList.get(i)+1;
                    for (int j = start; j + tobeReplacedNum <= s.length(); j++) {
                        String temp = s.substring(0, j) + tobeReplacedNum + s.substring(j+tobeReplacedNum);
                        res.add(temp);
                        int len = String.valueOf(tobeReplacedNum).length();
                        lastIndexList.add(j+len);
                        replaceNumList.add(count);
                    }
                }
            }
            count++;
        }
        res.add(word.length()+"");
        return res;
    }
}
