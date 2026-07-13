class Solution {
    public int countMonobit(int n) {
        
        int count=1;
        int current=1;
        while(current<=n){
            count++;
            current=current<<1 | 1;
        }
        return count;
    }
}