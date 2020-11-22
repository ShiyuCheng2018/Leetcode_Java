package _162_FindPeakElement;

public class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low + 1 < high) {
            int pivot = low + (high - low) / 2;

            if (nums[pivot] < nums[pivot + 1]) { // peek on the right
                low = pivot;
            } else if (nums[pivot] > nums[pivot + 1]) { // peek on the left
                high = pivot;
            }
        }

        if (nums[low] < nums[high]) return high;
        else return low;
    }
}
