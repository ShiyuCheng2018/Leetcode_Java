package _57_InsertInterval;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static int[][] insert(int[][] intervals, int[] newInterval){
        LinkedList<int[]> result = new LinkedList<>();
        // edge case
        if(intervals.length == 0){
            result.add(newInterval);
        }

        // find the index that newInterval should be placed
        int i = 0;
        if(newInterval.length != 0){
            for(int[] interval : intervals){
                if(interval[0] > newInterval[0]){
                    break; // found the index
                }
                i++;
            }
        }
        // iterate through the intervals
        for(int j = 0; j <= intervals.length; j++){
            // insert or merge the newInterval
            if(j == i && newInterval.length != 0){
                merge(newInterval, result);
            }
            // insert or merge other intervals
            if(j < intervals.length){
                merge(intervals[j], result);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void merge(int[] interval, LinkedList<int[]> result) {
        if(result.isEmpty() || result.getLast()[1] < interval[0]){
            // exclusive intervals
            result.add(interval);
        }else {
            result.getLast()[1] = Math.max(result.getLast()[1], interval[1]);
        }
    }
}
