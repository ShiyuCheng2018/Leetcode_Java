package _9_Palindrome_Number;

public class Solution {
    public boolean isPalindrome(int x){

        int reminder = 0, reversed = 0, original = x;
        while(original >= 1){
            reminder = original % 10; // get last digit
            reversed = reversed  * 10 + reminder; // update reversed
            original  /= 10;

        }

        return x == reversed; // see if reversed number == original
    }
}
