class Solution {
    public int subarrayLCM(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int lcm = 1;

            for (int j = i; j < nums.length; j++) {
                lcm = lcm(lcm, nums[j]);

                if (lcm == k) {
                    count++;
                }

                if (lcm > k || k % lcm != 0) {
                    break;
                }
            }
        }

        return count;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}