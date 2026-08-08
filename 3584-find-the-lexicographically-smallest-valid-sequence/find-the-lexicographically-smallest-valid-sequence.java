class Solution {
    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int[] ans = new int[m];

    
        int[] last = new int[m];

        for (int i = 0; i < m; i++) {
            last[i] = -1;
        }

        int i = n - 1;
        int j = m - 1;

        while (i >= 0 && j >= 0) {

            if (word1.charAt(i) == word2.charAt(j)) {
                last[j] = i;
                j--;
            }

            i--;
        }

        boolean canChange = true;

        j = 0;

        for (i = 0; i < n && j < m; i++) {

         
            if (word1.charAt(i) == word2.charAt(j)) {

                ans[j] = i;
                j++;

            }
          
            else if (canChange &&
                    (j == m - 1 || i < last[j + 1])) {

                ans[j] = i;
                canChange = false;
                j++;
            }
        }

        if (j != m) {
            return new int[0];
        }

        return ans;
    }
}