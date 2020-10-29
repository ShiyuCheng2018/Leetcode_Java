package _977_SquaresOfASortedArray;

public class Solution {
    public int[] sortedSquares(int[] array){

        int[] result = new int[array.length];
        // get the highest index of result
        int highestIndex = array.length - 1;
        // get the left and right indices of array
        int left = 0;
        int right = array.length - 1;

        while(left <= right){
            // get squares of left and right
            int leftSquare = array[left] * array[left];
            int rightSquare = array[right] * array[right];

            if(leftSquare > rightSquare){
                result[highestIndex--] = leftSquare;
                left++; // forwards left
            }else {
                result[highestIndex--] = rightSquare;
                right--; // backwards right
            }
        }

        return result;
    }
}
