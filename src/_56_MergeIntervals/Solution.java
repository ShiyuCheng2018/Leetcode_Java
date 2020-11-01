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
            _57_InsertInterval.Solution.merge(interval, result);
        }

        return result.toArray(new int[result.size()][]);
    }
}
