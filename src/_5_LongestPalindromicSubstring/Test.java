package _5_LongestPalindromicSubstring;

public class Test {
    public static void main(String[] args){

        String case_1 = "1221";
        String case_2 = "abba";
        String case_3 = "ababab";

        System.out.println("centralExtension: ");
        Palindrome palindrome = new Palindrome();
        palindrome.centralExtension_test(case_1);
        palindrome.centralExtension_test(case_2);
        palindrome.centralExtension_test(case_3);

        System.out.println("\ncentralExtensionOpti: ");
        palindrome.centralExtensionOpti_test(case_1);
        palindrome.centralExtensionOpti_test(case_2);
        palindrome.centralExtensionOpti_test(case_3);

    }
}
