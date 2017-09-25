package com.company;

import java.util.*;

public class ValidWordAbbr {
    //key is the abbre, value is corrsponging word
    Map<String, Set<String>> map;
    Set<String> set;
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        set = new HashSet<>();
        for (int i = 0; i< dictionary.length; i++) {
            String abbre = getAbbre(dictionary[i]);
            if(map.containsKey(abbre)) {
                map.get(abbre).add(dictionary[i]);
            } else {
                Set<String> list = new HashSet<>();
                list.add(dictionary[i]);
                map.put(abbre, list);
            }
            set.add(abbre);
        }


    }

    public boolean isUnique(String word) {
        String abbre = getAbbre(word);
        if (map.containsKey(abbre)) {
            if (map.get(abbre).size() == 1 && map.get(abbre).contains(word)) {
                return true;
            } else {
                return false;
            }

        }

        return !set.contains(abbre);
    }


    String getAbbre(String s) {
        if (s.length() <= 2) {
            return s;
        }

        int mid = s.length()-2;
        return "" + s.charAt(0) + mid + s.charAt(s.length()-1);
    }
}
