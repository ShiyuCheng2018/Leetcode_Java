package _424_LongestSubstringWithSameLettersAfterReplacement;

import java.util.HashMap;

public class Solution {
    public int LongestSubstringWithSameLettersAfterReplacement(String str, int k) {

        int maxRepeatedCount = 0;
        int maxLength = 0;
        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        for (int windowStart = 0, windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            // get the right edge of the window
            char right = str.charAt(windowEnd);
            // insert right or update right
            frequencyMap.put(right, frequencyMap.getOrDefault(right, 0) + 1);
            // update the maxRepeatedCount
            maxRepeatedCount = Math.max(maxRepeatedCount, frequencyMap.get(right));

            // check if the remain > k, which uses the total length of window - maxRepeatedCount
            if (windowEnd - windowStart + 1 - maxRepeatedCount > k) {
                // exceeds the remain of k
                // get the left;
                char left = str.charAt(windowStart);
                // decrease left from dict by 1, since we need to shrink the window
                frequencyMap.put(left, frequencyMap.get(left) - 1);
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    public int LongestSubarrayWithOnesAfterReplacement(int[] arr, int k) {
        int  maxOnesCount = 0;
        int maxLength = 0;

        for (int windowStart = 0, windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            // increase the maxOnesCount if new letter is 1
            if (arr[windowEnd] == 1) maxOnesCount++;
            // remaining letters = windowSize - maxRepeatedCount
            // to see if K times replacements are enough to the remaining letters in the window
            if (windowEnd - windowStart + 1 - maxOnesCount > k) {
                if (arr[windowStart] == 1) maxOnesCount--;
                windowStart++;
            }
            // update the maxLength
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
}
