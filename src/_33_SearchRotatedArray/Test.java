package _33_SearchRotatedArray;

public class Test {
    public static void main(String[] args){
        int[] arr_1 = {4,5,6,7,8,9,1,2,3};
        int[] arr_2 = {4,5,6,7,0,1,2};
        int[] arr_3 = {1, 2};
        int[] arr_4 = {5,1, 3};

        Solution solution = new Solution();
        System.out.println( "result: " + solution.search(arr_4, 5) );

    }
}
