class Solution {
    public int findJudge(int n, int[][] trust) {

        for (int candidate = 1; candidate <= n; candidate++) {

            boolean trustsSomeone = false;
            int count = 0;

            for (int i = 0; i < trust.length; i++) {

                if (trust[i][0] == candidate) {
                    trustsSomeone = true;
                    break;
                }
                if (trust[i][1] == candidate) {
                    count++;
                }
            }

            if (!trustsSomeone && count == n - 1) {
                return candidate;
            }
        }

        return -1;
    }
}