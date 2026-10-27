class Solution {
    public int dominantIndex(int[] nums) {
        
        int n=nums.length;
        int max=0;
        int index=0;
        for(int i=0;i<n;i++){
            if(max<nums[i]){
                max=nums[i];
                index=i;
            }
        }

        for(int i=0;i<n;i++){
            if(max>=2*nums[i]|| i==index){
                continue;
            }else{
                return -1;
            }
        }
        return index;
    }
}