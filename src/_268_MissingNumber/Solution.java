package _268_MissingNumber;

public class Solution {
    public int missingNumber(int[] nums){
        int i = 0;
        while(i < nums.length){
            if(nums[i] < nums.length && nums[i] != nums[nums[i]] ){
                swap(nums, i, nums[i]);
            }else {
                i++; // increase i if only if index i has correct number
            }
        }

        for(int each = 0; each < nums.length; each++){
            if(each != nums[each]){
                return each;
            }
        }

        return nums.length;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


