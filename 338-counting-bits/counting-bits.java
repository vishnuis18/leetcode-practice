class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int j = 0; j <= n; j++) {
            int count = 0;
            int let = j;

            while (let > 0) {
                let = let - (let & (-let));
                count++;
            }

            ans[j] = count;
        }

        return ans;
    }
}