class Solution {
    public void moveZeroes(int[] nums) {

        int n=nums.length;
        int[] temp=new int[n];
        int j=0;
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                temp[j]=nums[i];
                j++;
            }
        }

        for(int i=0;i<n;i++){
            nums[i]=temp[i];
        }

    }
}