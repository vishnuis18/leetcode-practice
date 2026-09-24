class Solution {
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            if (sum == i) {
                return i;
            }
        }
        return -1;
    }
}
/*
class Solution {
    public int smallestIndex(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            int num = nums[i];
            String no = String.valueOf(num);
            for (int j = 0; j < no.length(); j++) {
                char ch = no.charAt(j);
                sum = sum + ch - '0';
            }
            if (sum == i) {
                return i;
            }
        }
        return -1;
    }
}
*/