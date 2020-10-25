package _56_MergeIntervals;

import java.util.*;

public class Solution {

    private class IntervalComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            return a[0] < b[0] ? -1 : a[0] == b[0] ? 0 : 1;
        }
    }

    public int[][] merge(int[][]intervals){

        // sorting based on the left num of the interval
        Collections.sort(Arrays.asList(intervals), new IntervalComparator());

        LinkedList<int[]> result = new LinkedList();

        for(int[] interval : intervals){
            if(result.isEmpty() || result.getLast()[1] < interval[0]){ // first condition
                result.add(interval); // add the new interval
            }else{ // under the second condition:
                   // ! result.isEmpty() && result.getLast()[1] > interval[0]
                result.getLast()[1] = Math.max(result.getLast()[1], interval[1]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
