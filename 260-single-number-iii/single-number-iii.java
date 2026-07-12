class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;

        // Step 1: XOR all numbers
        for (int num : nums) {
            xor ^= num;
        }

        // Step 2: Find rightmost set bit
        int diffBit = xor & (-xor);

        int a = 0;
        int b = 0;

        // Step 3: Divide numbers into 2 groups
        for (int num : nums) {
            if ((num & diffBit) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[]{a, b};
    }
}