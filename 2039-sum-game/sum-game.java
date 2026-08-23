class Solution {
    public boolean sumGame(String num) {
        int leftsum=0;
        int rightsum=0;
        int leftq=0;
        int rightq=0;
        int n=num.length();

        for(int i=0;i<n/2;i++){
            char l=num.charAt(i);
            char r=num.charAt(n-1-i);

            if(l == '?'){
                leftq++;
            }else{
                leftsum+=l-'0';
            }

            if(r=='?'){
                rightq++;
            }else{
                rightsum+=r-'0';
            }
        }

        int diffofnum=leftsum-rightsum;
        int diffq=rightq-leftq;

        return 2* diffofnum != 9*(diffq); // leftsum+(4.5*leftq)!=rightsum+(4,5*rightsum);
    }
}