class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        ArrayList<Integer> prefix = new ArrayList<>();
        ArrayList<Integer> suffix = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            suffix.add(nums[i]);
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            prefix.add(nums[i]);
            max = Math.max(max, prefix.get(i));
            min = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                min = Math.min(min, suffix.get(j));
            }
            if ((max - min) <= k) {
                return i;
            }
        }
        return -1;
    }
}