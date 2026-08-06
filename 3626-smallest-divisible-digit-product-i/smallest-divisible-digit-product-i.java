class Solution {
    public int smallestNumber(int n, int t) {
        int i=n;
        
        while(i>=n){
            String str=String.valueOf(i);
            int product=1;
            for(int j=0;j<str.length();j++){
                char ch=str.charAt(j);
                int num=ch-'0';
                product*=num;
            }
            if(product%t==0){
                return i;
            }
            i++;
        }
        return -1;

    }
}