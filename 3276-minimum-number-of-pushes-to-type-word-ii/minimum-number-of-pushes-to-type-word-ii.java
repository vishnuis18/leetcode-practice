import java.util.Arrays;

class Solution {
    public int minimumPushes(String word) {

        Integer[] freq = new Integer[26];
        Arrays.fill(freq, 0);

        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }

        Arrays.sort(freq, java.util.Collections.reverseOrder());

        int result = 0;

        for (int i = 0; i < 26; i++) {
            int press = i / 8 + 1;
            result += press * freq[i];
        }

        return result;
    }
}