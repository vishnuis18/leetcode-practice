class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        if(n==1){
            return 0;
        }
        int count=0;
        for(int i=0;i<n-1;i++){
            while(nums[i]>=nums[i+1]){
                nums[i+1]++;
                count++;
            }
        }
        return count;
    }
}