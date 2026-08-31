class Solution {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int left=0;
        int right=nums.length-1;
        double minum=Integer.MAX_VALUE;
        while(left<right){
            double avg=(nums[left]+nums[right])/2.0;
            minum=Math.min(minum,avg);
            left++;
            right--;
        }
        return minum;
    }
}