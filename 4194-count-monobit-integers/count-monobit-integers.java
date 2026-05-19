class Solution {
    public int countMonobit(int n) {
        int count=0;
        for (int i=0;i<=n;i++){
            String b = Integer.toBinaryString(i);
            if(!b.contains("01") && !b.contains("10")){
                count++;
            }
        }
        return count;
    }
}
