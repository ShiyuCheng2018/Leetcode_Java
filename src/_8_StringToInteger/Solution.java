package _8_StringToInteger;

public class Solution {
    public int myAtoi(String s){
        // s.length = 0 返回0;
        if (s.length() == 0) return 0;

        int sign = 1;
        int result = 0;

        // 遍历直到有字符
        int i = 0;
        while (i < s.length() && s.charAt(i) == ' '){
            i++;
        }

        // 判断当前字符是否是 + 或 -
        if(i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')){
            sign = s.charAt(i++) == '+' ? 1 : -1; // 判断好符号， 然后把i推后一位
        }

        // 遍历转换数字字符
        while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
            // 判断溢出情况
            if (result > Integer.MAX_VALUE / 10 ||
                    (result == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + (s.charAt(i++) - '0') ; // 减-'0'是为了得到int数字， 比如'7'(55)-'0'(48) = 7
        }

        return result * sign;
    }
}
