package _5_LongestPalindromicSubstring;

public class Palindrome {


    public void centralExtension_test(String text) {
        centralExtension(text);
    }

    public String centralExtension(String text) {
        if (text == null || text.length() == 0) {
            return "";
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < text.length(); i++) {
            sb.append('#');
            sb.append(text.charAt(i));

        }
        sb.append('#');

        char[] arr = sb.toString().toCharArray();

        int longest = 0;
        String result = "";


        for (int curr = 0; curr <= arr.length; curr++) {

            if (extensionRound(arr, curr) > longest) {
                longest = extensionRound(arr, curr);
                result = new String(arr).substring(curr - longest, curr + longest + 1);
            }

        }

        System.out.println(result.replace("#", ""));
        return result.replace("#", "");
    }

    private int extensionRound(char arr[], int curr) {

        int length = 0;

        for (int i = curr - 1, j = 1; i >= 0 && curr + j < arr.length; i--, j++) {
            if (arr[i] == arr[curr + j]) {
                length++;
            } else {
                break;
            }
        }

        return length;
    }

}
