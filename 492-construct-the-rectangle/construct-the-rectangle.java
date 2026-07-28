class Solution {
    public int[] constructRectangle(int area) {
        int sq = (int) Math.sqrt(area);
        int w=0;;
        int l=0;
        for(int i=sq;i>=1;i--){
            if(area % i==0){
                w=i;
                l=area/w;
                break;
            }
        }
        
        int[] ans=new int[2];
        ans[0]=l;
        ans[1]=w;
        
        return ans;
        
    }
}