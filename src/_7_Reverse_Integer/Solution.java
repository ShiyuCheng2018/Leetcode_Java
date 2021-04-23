package _7_Reverse_Integer;

public class Solution {
    public int reverse(int x){
        int reversed = 0, reminder, original = x;

        while(original != 0){
            reminder  = original % 10; // get reminder;
            if(reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && reminder > 7)) return 0;
            if(reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && reminder < -8)) return 0;
            reversed = reversed * 10 +  reminder ; // update reminder
            original /= 10;
        }

        return reversed;
    }
}
