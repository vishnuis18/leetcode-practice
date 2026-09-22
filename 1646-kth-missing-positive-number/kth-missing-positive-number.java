class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n=arr.length;
        ArrayList<Integer> ans=new ArrayList<>();
        if(arr[0]>1){
            int diff=arr[0]-1;
            int num=1;
            while(diff>0){
                ans.add(num);
                num++;
                diff--;
            }
        }

        for(int i=1;i<n;i++){
            int diff=arr[i]-arr[i-1]-1;
            int num=arr[i-1]+1;

            while(diff>0){
                ans.add(num);
                num++;
                diff--;
            }
            
        }
        int num=arr[n-1]+1;
        while(ans.size()<k){
            ans.add(num);
            num++;
        }
        return ans.get(k-1);
    }
}