class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int freq=1;
        int n=nums.length;
        int value=n/2;

        for(int i=1;i<n;i++){
            if(nums[i]==nums[i-1]){
                freq++;
                if(freq>value){
                    return nums[i];
                }
            }else{
                freq=1;
            }
        }
        return nums[0];
    }
}
