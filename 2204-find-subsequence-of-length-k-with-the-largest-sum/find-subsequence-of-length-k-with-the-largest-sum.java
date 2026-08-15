class Solution {
    public int[] maxSubsequence(int[] nums, int k) {

        int n = nums.length;

        Integer[] index = new Integer[n];

        for (int i = 0; i < n; i++) {
            index[i] = i;
        }

        Arrays.sort(index, (a, b) -> nums[b] - nums[a]);

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = index[i];
        }

        Arrays.sort(ans);

        for (int i = 0; i < k; i++) {
            ans[i] = nums[ans[i]];
        }

        return ans;
    }
}