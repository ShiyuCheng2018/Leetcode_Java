package No_Repeated_Substring;

public class Test {
    public static void main(String[] args){
        String test_1= "abcae";
        String test_2 = "aabccbb";
        String test_3 = "abbbb";
        String test_4 = "abccde";

        Solution solution= new Solution();
        solution.noRepeatedSubstring(test_1);
        solution.noRepeatedSubstring(test_2);
        solution.noRepeatedSubstring(test_3);
        solution.noRepeatedSubstring(test_4);
    }
}
