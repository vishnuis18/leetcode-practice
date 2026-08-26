class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int size=n-k+1;
        ArrayList<Integer> ans=new ArrayList<>(size);
        ArrayList<Integer> list=new ArrayList<>();

        int i=0;
        int j=0;
        while(j<n){
            if(list.isEmpty()){
                list.add(nums[j]);
            }else{
                while(list.size()!=0 && list.get(list.size()-1)<nums[j]){
                    list.remove(list.size()-1);
                }
                list.add(nums[j]);
            }

            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k){
                ans.add(list.get(0));

                if(nums[i]==list.get(0)){
                    list.remove(0);
                }
                i++;
                j++;
            }
        }
        int[] answer=new int[ans.size()];
        for(int l=0;l<ans.size();l++){
            answer[l]=ans.get(l);
        }
        return answer;
    }
}