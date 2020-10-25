package _49_GroupAnagrams;

import java.util.*;

public class Sulotion {
    public List<List<String>> groupAnagrams(String[] strs){

        if(strs.length == 0) return new ArrayList();
        Map<String, List> map = new HashMap();

        for (String str : strs){
            char[] charSet = str.toCharArray();
            Arrays.sort(charSet); // sorting string
            String key = String.valueOf(charSet);
            if(!map.keySet().contains(key)){ //
                map.put(key, new ArrayList()); // create a new key
            }
            map.get(key).add(str); // put into the map
        }
        return new ArrayList(map.values()); // return all values
    }
}
