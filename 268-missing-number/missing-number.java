class Solution {
    public int missingNumber(int[] nums) {
        int ans=0;
        for(int n:nums){
            ans=ans^n;
        }
        int let=0;
        for(int i=0;i<=nums.length;i++){
            let=let^i;
        }
        return let^ans;
    }
}