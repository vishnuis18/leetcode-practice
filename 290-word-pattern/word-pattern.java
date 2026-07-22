import java.util.*;

class Solution {
    public boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");

        if (words.length != pattern.length()) {
            return false;
        }

        HashMap<Character, String> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {

            char ch = pattern.charAt(i);
            String word = words[i];

            if (map.containsKey(ch)) {
                if (!map.get(ch).equals(word)) {
                    return false;
                }

            } else {
                if (map.containsValue(word)) {
                    return false;
                }

                map.put(ch, word);
            }
        }

        return true;
    }
}