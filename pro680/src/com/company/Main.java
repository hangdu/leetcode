package com.company;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	// write your code here
        boolean test;
        test = validPalindrome("aba");
    }

    public static boolean validPalindrome(String s) {
        if (s.length() <= 2) {
            return true;
        }

        return helper(s, 0, s.length()-1, true);
        //two pointer


    }

    static boolean helper(String s, int start, int end, boolean hasChance) {
        while (start <= end) {
            char c1 = s.charAt(start);
            char c2 = s.charAt(end);
            if (c1 == c2) {
                start++;
                end--;
            } else {
                if (!hasChance) {
                    return false;
                }

                //has chance
                hasChance = false;
                if (start + 1 == end) {
                    return true;
                }

                if (start +2 == end) {
                    char c3 = s.charAt(start+1);
                    if (c3 == c1 || c3 == c2)  {
                        return true;
                    } else {
                        return false;
                    }
                }

                char c3 = s.charAt(start+1);
                char c4 = s.charAt(end-1);

                if (c1 != c4) {
                    if (c2 != c3) {
                        return false;
                    } else {
                        return helper(s, start+1, end, hasChance);
                    }
                } else {
                    if (c2!=c3) {
                        return helper(s, start, end-1, hasChance);
                    } else {
                        return helper(s, start+1, end, hasChance) || helper(s, start, end-1, hasChance);
                    }
                }

            }
        }
        return true;
    }


}
