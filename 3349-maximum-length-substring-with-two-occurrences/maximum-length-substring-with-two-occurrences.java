class Solution {
    public int maximumLengthSubstring(String s) {

        int[] freq = new int[26];

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);
            freq[ch - 'a']++;

            // If any character occurs more than twice,
            // shrink the window from the left.
            while (freq[ch - 'a'] > 2) {

                freq[s.charAt(left) - 'a']--;
                left++;
            }

            // Current window is valid
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}