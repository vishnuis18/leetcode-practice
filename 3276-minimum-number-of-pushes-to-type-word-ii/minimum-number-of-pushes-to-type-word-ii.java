import java.util.Arrays;

class Solution {
    public int minimumPushes(String word) {

        int[] freq = new int[26];

        // Count frequency of each character
        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }

        Arrays.sort(freq);

        int result = 0;
        int press = 1;
        int count = 0;
        
        for (int i = 25; i >= 0; i--) {

            if (freq[i] == 0) break;

            result += freq[i] * press;

            count++;

            if (count == 8) {
                press++;
                count = 0;
            }
        }

        return result;
    }
}