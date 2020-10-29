package _26_RemoveDuplicateFromSortedArray;

public class Solution {
    public int removeDuplicates(int[] nums) {
        /**
         * i: index pointer that iterate the whole array
         * noneDuplicate: points that the current last none-duplicate's index
         * */
        int noneDuplicate = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[noneDuplicate] != nums[i]) { // encounter a new none-duplicate
                // prepare next index for shifting the new none-duplicate
                noneDuplicate++;
                // shift the none-duplicate to the left
                nums[noneDuplicate] = nums[i];
            }
        }
        // because it starts at the '0' index of first none-duplicate
        return noneDuplicate + 1;
    }
}
