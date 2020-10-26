package LongestSubstringwithKDistinctCharacters;

import java.util.HashMap;

public class Solution {
    public static int findLength(String str, int k) {

        int longest = 0;
        int windowStart = 0;
        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){

            // get the right edge of the window
            char right = str.charAt(windowEnd);
            // add the right into the map
            frequencyMap.put(right, frequencyMap.getOrDefault(right, 0)+1);

            // check the K condition in the window (frequencyMap)
            while(frequencyMap.size() > k){
                // get the left edge of the window
                char left = str.charAt(windowStart);
                // decrease the left
                frequencyMap.put(left, frequencyMap.get(left)-1);
                if(frequencyMap.get(left) == 0){
                    frequencyMap.remove(left); // delete the left key in the map
                }
                windowStart ++; // shrink the window size
            }
            // update the the longest;
            longest = Math.max(longest, windowEnd - windowStart +1); // +1 since it starts from 0
        }

        return longest;
    }
}
