package com.shams.others;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LongestSubstring {

	public static void main(String[] args) {
		System.out.println(new LongestSubstring().lengthOfLongestSubstringOptimized("abbbaaa"));

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
		int start = 0;
		if (s.length() < 3) return 1;
		int ans = 0;
		int max = 0;
		List<Character> c = new LinkedList<>();
		for (int i = 0; i < s.length(); i++) {
			char p = s.charAt(i);
			if (c.contains(p)) {
				if(!(start == 0 && ans == 0)) {
					start = c.lastIndexOf(p);
				} else {
					
				}
				max = c.size() -  (start);
				if (ans < max) ans = max;
			}
			c.add(p);
		}
		return ans;
	}

}
