class Solution {
    public int minimumSwaps(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int count = 0;

        while (left < right) {
            if (nums[left] == 0 && nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                count++;

                left++;
                right--;
            } 
            else if (nums[left] != 0) {
                left++;
            } 
            else if (nums[right] == 0) {
                right--;
            }
        }

        return count;
    }
}