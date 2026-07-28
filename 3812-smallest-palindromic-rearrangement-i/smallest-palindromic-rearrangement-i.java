import java.util.*;

class Solution {
    public String smallestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }

        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        int n = s.length();

        HashMap<Character, Integer> map = new HashMap<>();

       
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        StringBuilder left = new StringBuilder();
        String middle = "";

        
        for (int i = 0; i < n; ) {
            char ch = arr[i];
            int freq = map.get(ch);

            for (int j = 0; j < freq / 2; j++) {
                left.append(ch);
            }

            if (freq % 2 == 1) {
                middle = String.valueOf(ch);
            }

            i += freq;
        }

        String right = new StringBuilder(left).reverse().toString();

        return left.toString() + middle + right;
    }
}