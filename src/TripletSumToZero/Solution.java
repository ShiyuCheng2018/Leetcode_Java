package TripletSumToZero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> searchTriplets(int[] array){
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(array); // sort the array
        // iterate the whole array
        for (int i = 0; i < array.length - 2; i++){
            if(i > 0 && array[i] == array[i-1]){
                continue; // skip the duplicate numbers
            }
            // search the remain two numbers' sum is -array[i]
            search(array, -array[i], i+1, triplets);
        }
        return triplets;
    }

    private void search(int[] array, int target, int left, List<List<Integer>> triplets) {
        // get the right edge's index of the array
        int right = array.length - 1;
        // it has to be left index < right index
        while(left < right){
            int currentSum = array[right] + array[left];
            // see if the currentSum is equal to the target
            if(currentSum == target){
                triplets.add(Arrays.asList(-target, array[left], array[right]));
                left++; // forward pointers
                right--;
                while(left < right && array[left] == array[left - 1]){
                    left++; // skip the duplicate
                }
                while(left < right && array[right] == array[right + 1]){
                    right++; // skip the duplicate
                }
            }else if(currentSum > target){
                right--; // need a smaller right
            }else {
                left++; // need a bigger left
            }
        }
    }
}

