package _30_SubstringWithConcatenationOfAllWords;

public class Test {
    public static void main(String[] args){

        String test_1 = "barfoothefoobarman";
        String test_2 = "wordgoodgoodgoodbestword";
        String test_3 ="barfoofoobarthefoobarman";
        String test_4 = "wordgoodgoodgoodbestword";

        String[] words_1 = {"bar", "foo", "the"};
        String[] words_2 = {"bar", "foo"};
        String[] words_3 = {"word","good","best","word"};
        String[] words_4 =  {"word","good","best","good"};

//        new Solution().findSubString(test_1, words_2);
//        new Solution().findSubString(test_2, words_1);
//        new Solution().findSubString(test_3, words_1);
//        new Solution().findSubString(test_4, words_3);
        new Solution().findSubString(test_4, words_4);

    }
}
