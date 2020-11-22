package _33_SearchRotatedArray;

public class Solution {
    public int findRotatedIndex(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        if (arr[low] < arr[high]) { // sorted array
            return 0;
        }
        // pick the middle element as a pivot
        while (low <= high) {
            int middle = low + (high - low) / 2;
            // compare array[middle] with first element and next element
            if (arr[middle] > arr[middle + 1]) {
                return middle + 1;
            } else {
                if (arr[middle] < arr[low]) {
                    high = middle - 1;
                } else {
                    low = middle + 1;
                }
            }
        }
        return 0;
    }

    public int search(int[] arr, int target) {
        if (arr.length == 0) return -1;
        if (arr.length == 1) return arr[0] == target ? 0 : -1;

        int rotatedIndex = findRotatedIndex(arr);
        if (rotatedIndex == 0) {
            return binarySearch(arr, 0, arr.length - 1, target);
        }
        // identify the sorted part to search
        if (target < arr[0]) {
            return binarySearch(arr, rotatedIndex, arr.length - 1, target);
        } else if (target >= arr[0]) {
            return binarySearch(arr, 0, rotatedIndex, target);
        }
        return -1;
    }

    private int binarySearch(int[] arr, int start, int end, int target) {
        int low = start;
        int high = end;

        while (low + 1 < high) {
            int middle = low + (high - low) / 2;

            if (arr[middle] < target) {
                low = middle;
            } else if (arr[middle] > target) {
                high = middle;
            } else {
                return middle;
            }
        }

        if (arr[low] == target) return low;
        else if (arr[high] == target) return high;
        else return -1;
    }
}
