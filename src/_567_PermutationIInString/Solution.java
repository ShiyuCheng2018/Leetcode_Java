package _567_PermutationIInString;

import java.util.HashMap;

public class Solution {
    public boolean PermutationIInString(String str, String pattern) {
        int matchCount = 0;
        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        // create the frequencyMap for the pattern
        for (char each : pattern.toCharArray()) {
            frequencyMap.put(each, frequencyMap.getOrDefault(each, 0) + 1);
        }

        // create the sliding window
        for (int windowEnd = 0, windowStart = 0; windowEnd < str.length(); windowEnd++) {

            int windowSize = windowEnd - windowStart + 1;

            // see if the new letter (right edge of the window) in the map
            char right = str.charAt(windowEnd);
            if (frequencyMap.containsKey(right)) {
                // when the frequency of right  >= 1
                frequencyMap.put(right, frequencyMap.get(right) - 1);
                if (frequencyMap.get(right) == 0) { // the letter is completed
                    matchCount++;
                }
            }

            if (windowSize > pattern.length()) { // shrink the window if windowSize > pattern length
                // if left edge going out is part of pattern, put it back to map
                char left = str.charAt(windowStart);
                if (frequencyMap.containsKey(left)) {
                    if (frequencyMap.get(left) == 0) { // the letter was completed
                        matchCount--; // recover matchCount by 1
                    }
                    // recover the frequency
                    frequencyMap.put(left, frequencyMap.getOrDefault(left, 0) + 1);
                }
                // shrink the window
                windowStart++;
            }

            // check
            if (matchCount == frequencyMap.size()) {
                return true;
            }
        }

        return false;
    }
}
