package Facebook;

public class LengthOfLongestSubstring {

    public int solve(String s){

        if (s.length() == 0){
            return 0;
        }

        if (s.length() == 1){
            return 1;
        }

        Integer max = 0;
        for (int ch = 0; ch < s.length(); ch++){
            String sub_s = ""+s.charAt(ch);

            for (int each = ch+1; each < s.length(); each++){
                if (!sub_s.contains(""+s.charAt(each))){
                    sub_s += s.charAt(each);

                }else {

                    break;
                }
            }

            if(max < sub_s.length()){
                max = sub_s.length();
            }
        }

        return  max;
    }
}

class Main {

    public static void main(String[] args) {
        LengthOfLongestSubstring i = new LengthOfLongestSubstring();
        System.out.println(i.solve("abcabcb"));
    }
}




