package _438_FindAllAnagramsInString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<Integer> findStringAnagrams(String str, String pattern) {
        // create a frequency map of each letter from the pattern
        List<Integer> resultIndices = new ArrayList<Integer>();
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for (char each : pattern.toCharArray()) {
            frequencyMap.put(each, frequencyMap.getOrDefault(each, 0) + 1);
        }

        // create  a window
        for (int windowStart = 0, windowEnd = 0, matchCount = 0; windowEnd < str.length(); windowEnd++) {
            // get the right edge
            char right = str.charAt(windowEnd);
            // check if the right edge in the map
            if (frequencyMap.containsKey(right)) {
                frequencyMap.put(right, frequencyMap.getOrDefault(right, 0) - 1);
                if (frequencyMap.get(right) == 0) { // completed the letter amount in the pattern
                    matchCount++;
                }
            }

            // get the windowSize
            int windowSize = windowEnd - windowStart + 1; // starts from 0
            // see if the windowSize > length of pattern, if yes, we shrink the window
            if (windowSize > pattern.length()) {
                // get the left
                char left = str.charAt(windowStart);
                if (frequencyMap.containsKey(left)) {
                    if (frequencyMap.get(left) == 0) {
                        // recover matchCount by 1
                        matchCount--;
                    }
                    frequencyMap.put(left, frequencyMap.get(left) + 1);
                }
                windowStart++;
            }

            if (matchCount == frequencyMap.size()) {
                // our window covers the patterns' permutation
                resultIndices.add(windowStart); // add the start index
            }
        }
        return resultIndices;
    }
}
