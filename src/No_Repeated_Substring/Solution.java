package No_Repeated_Substring;

import java.util.HashMap;

public class Solution {
    public int noRepeatedSubstring(String str){
        if(str.isEmpty()) return 0;

        int max = 0;
        HashMap<Character, Integer> indexMap = new HashMap<>();

        for(int windowEnd = 0, windowStart = 0; windowEnd < str.length(); windowEnd++){
            // get the right edge of the window
            char right = str.charAt(windowEnd);

            if(indexMap.containsKey(right)){
                // shrink the window
                // if windowStart already ahead of last index of "right", keep windowStart
                // else, rest windowStart to the next position of previous index of "right"
                windowStart = Math.max(windowStart, indexMap.get(right)+1);
            }

             indexMap.put(right, windowEnd);
            // update max
            max = Math.max(max, windowEnd - windowStart + 1);
        }
        System.out.println(max);
        return max;
    }
}

