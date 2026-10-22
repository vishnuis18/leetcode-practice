class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        boolean asc = true;
        boolean dsc = true;

        for (int i = 1; i < n; i++) {
            if (nums[i] != (nums[i - 1] + 1) % n) {
                asc = false;
            }

            if (nums[i - 1] != (nums[i] + 1) % n) {
                dsc = false;
            }
        }

        if (asc) {
            if (nums[0] == 0) {
                return 0;
            }

            return Math.min(n - nums[0], nums[0] + 2);
        }

        if (dsc) {
            return Math.min(n - nums[n - 1], nums[n - 1]) + 1;
        }

        return -1;
    }
}