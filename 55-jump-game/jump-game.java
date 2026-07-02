class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1 && nums[0] == 0) {
            return true;
        }
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(max==0){
                max=nums[i];
            }
            int sum=nums[i]+i;
            if(sum>max){
                max=sum;
            }else if(max>=nums.length-1){
                return true;
            }else if(i==max && nums[i]==0){
                return false;
            }
        }
        return true;
    }
        
}