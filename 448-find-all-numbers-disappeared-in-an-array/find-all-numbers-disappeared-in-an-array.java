import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        ArrayList<Integer> ans = new ArrayList<>();
        int j = 0;

        for (int i = 1; i <= n; i++) {
            while (j < n && nums[j] < i) {
                j++;
            }

            if (j < n && nums[j] == i) {
                j++;
            } else {
                ans.add(i);
            }
        }

        return ans;
    }
}


/*
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n=nums.length;

        ArrayList<Integer> nums1=new ArrayList<>();
        for(int i=0;i<n;i++){
            nums1.add(nums[i]);
        }
        
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=i+1;
        }

        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(nums1.indexOf(arr[i])==-1){
                 ans.add(arr[i]);
            }
           
        }
        
        return ans;
    }
}
*/