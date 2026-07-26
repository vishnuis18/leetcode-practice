class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        return Math.max(
            nums[n - 1] * nums[n - 2] * nums[n - 3],
            nums[0] * nums[1] * nums[n - 1]
        );
    }
}
/*
Math.max(
    largest * secondLargest * thirdLargest,
    smallest * secondSmallest * largest
);
*/
/*
class Solution {
    public int maximumProduct(int[] nums) {
        int prod = Integer.MIN_VALUE;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int ans = nums[i] * nums[j] * nums[k];
                    prod = Math.max(prod, ans);
                }
            }
        }

        return prod;
    }
}
*/