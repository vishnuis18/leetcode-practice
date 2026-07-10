class Solution {
    public int hammingWeight(int n) {
        String ans=Integer.toBinaryString(n);
        int count=0;
        for(int i=0;i<ans.length();i++){
            if(ans.charAt(i)=='1'){
                count++;
            }
        }
        return count;

    }
}