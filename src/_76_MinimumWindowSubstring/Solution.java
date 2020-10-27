package _76_MinimumWindowSubstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public String findSubstring(String str, String pattern) {

        // create a frequency map of each letter from the pattern
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for (char each : pattern.toCharArray()) {
            frequencyMap.put(each, frequencyMap.getOrDefault(each, 0) + 1);
        }

        int minimumLength = str.length();
        String minimumString = "";

        for (int windowStart = 0, windowEnd = 0, matchCount = 0; windowEnd < str.length(); windowEnd++) {

            // get the right edge of the window
            char right = str.charAt(windowEnd);
            if (frequencyMap.containsKey(right)) {
                // update the frequency of th right
                frequencyMap.put(right, frequencyMap.get(right) - 1);
                if (frequencyMap.get(right) == 0) {
                    // completed this letter in the pattern
                    matchCount++;
                }

                if (frequencyMap.get(right) <= 0) {
                    char left = str.charAt(windowStart);
                    // we have extra the right, we have to shrink until the left just completed
                    while (!frequencyMap.containsKey(left) || frequencyMap.get(left) < 0) {
                        if (frequencyMap.containsKey(left)) {
                            frequencyMap.put(left, frequencyMap.get(left) + 1);
                        }
                        // shrink the window
                        windowStart++;
                        left = str.charAt(windowStart);
                    }

                }
            }

            // see if it meets the requirement
            if (matchCount == frequencyMap.size()) {
                String windowString = str.substring(windowStart, windowEnd + 1);
                if (minimumLength >= windowString.length()) {
                    minimumString = windowString;
                    minimumLength = windowString.length();
                }
            }
        }
        System.out.println(minimumString);
        return minimumString;
    }
}
