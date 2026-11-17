class Solution {
    public int maxProfit(int[] arr) {
        int n=arr.length;
        int min=Integer.MAX_VALUE;
        int maxprofit=0;

        for(int i=0;i<n;i++){
            if(arr[i]<min){
                min=arr[i];
            }
            int profit=(arr[i]-min);
            if(profit>maxprofit){
                maxprofit=profit;
            }
        }
        return maxprofit;
    }
}