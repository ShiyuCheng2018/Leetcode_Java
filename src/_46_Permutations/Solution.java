package _46_Permutations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> permutations = new LinkedList<>();
        // add first empty array to permutations
        ((LinkedList<List<Integer>>) permutations).add(new ArrayList<>());

        for(int curr : nums){
            // take all existing permutations and add the curr to create new permutations
            int n = permutations.size();
            for(int i = 0; i < n; i++){
                List<Integer> oldPermutation = permutations.poll();
                // create a new permutation by adding the current number at every position
                for(int j = 0; j <= oldPermutation.size(); j++){
                    List<Integer> newPermutation = new ArrayList<>(oldPermutation);
                    newPermutation.add(j ,curr);

                    if(newPermutation.size() == nums.length){
                        result.add(newPermutation);
                    }else {
                        ((LinkedList<List<Integer>>) permutations).add(newPermutation);
                    }

                }
            }
        }
        return result;
    }
}
