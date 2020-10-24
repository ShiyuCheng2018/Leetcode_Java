package _6_ZigZagConversation;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class solution {
    public String convert(String text, int numRows) {

        if(numRows == 1) return text; // return the string if numRows is 1

        List<List<Character>> buckets = new ArrayList<>();
        for(int i = 0; i < numRows; i++)  {
            buckets.add(new ArrayList<>());
        }

        int flag = -1; // flag for direction
        int bucket = 0; // initial bucket

        for (char each : text.toCharArray()) {
            buckets.get(bucket).add(each);

            if (bucket == 0 || bucket == numRows - 1) { // if it is the edge bucket (first bucket or last bucket)
                flag *= -1; // change the direction
            }

            bucket += flag; // move to next bucket
        }

        // iterate the buckets and conduct the final string
        StringBuilder result = new StringBuilder();
        for (List each : buckets) {
            while (each.size() !=0){
                result.append(each.remove(0));
            }
        }

        return result.toString();
    }
}
