package _567_PermutationIInString;



public class Test {
    public static void main(String[] args){

        Solution solution = new Solution();
        boolean result_1 = solution.PermutationIInString("aaacb", "abc");
        System.out.println(result_1);
        boolean result_2 = solution.PermutationIInString("odicf", "dc");
        System.out.println(result_2);
        boolean result_3 = solution.PermutationIInString("oidbcaf", "abc");
        System.out.println(result_3);

    }
}
