class Solution {
    public int bulbSwitch(int n) {
        int count=0;
        for(int i=1;i<=n;i++){
            int root = (int)Math.sqrt(i);
            if(root*root==i){
                count++;
            }
        }
        return count;
        
    }
}