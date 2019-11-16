package com.shams.others;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LongestSubstring {

	public static void main(String[] args) {
		System.out.println(new LongestSubstring().longestPalindrome("abababaccbcbcbcbcbc"));

	}
	
	
	public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int count = 0;
        int initIndex = -1;
        Set<Character> c = new HashSet<>();
         for (int i = 0; i < s.length();) {
             char p = s.charAt(i);
             if (initIndex < 0) {
                 initIndex = 0;
             }
             if (c.add(p)) {
                 count++;
             } else {
                if (max < count) {
                    max = count;
                }
                initIndex++;
                i = initIndex;
                count = 0;
                c.clear();
                continue;
             }
             i++;
         }
        return max > count ? max:count;
    }
	
	//Optimized
	// TODO Modify code to skip re-checking characters once a duplicate character found.
	public int lengthOfLongestSubstringOptimized(String s) {
        int max = 0;
        int count = 0;
        int initIndex = -1;
        Set<Character> c = new HashSet<>();
         for (int i = 0; i < s.length();) {
             char p = s.charAt(i);
             if (initIndex < 0) {
                 initIndex = 0;
             }
             if (c.add(p)) {
                 count++;
             } else {
                if (max < count) {
                    max = count;
                }
                initIndex++;
                i = initIndex;
                count = 0;
                c.clear();
                continue;
             }
             i++;
         }
        return max > count ? max:count;
    }
	
	public String longestPalindrome(String s) {
		StringBuffer sb = new StringBuffer();
		String r = "";
		int max = 0;
		int count = 0;
		int initIndex = -1;
		if(s.length() == 1) return s;
		for (int i = 0; i < s.length();) {
			String p = s.charAt(i)+"";
			if (initIndex < 0) {
				initIndex = 0;
			}
			sb.append(p);
			count++;
			String t = sb.reverse().toString();
			if (t.length() > 1 && max < count && t.equals(sb.reverse().toString())) {
				r = sb.toString();
				max = count;
			} else if (i == s.length() -1 && initIndex != s.length()) {
				initIndex++;
				i = initIndex;
				sb.delete(0, sb.length());
				count = 0;
				continue;
			}
			i++;
		}
		return r.toString();
	}

}
