class Solution {
    public boolean checkDivisibility(int n) {
        String num=String.valueOf(n);

        int product=1;
        int sum=0;
        for(int i=0;i<num.length();i++){
            product*=Integer.parseInt(String.valueOf(num.charAt(i)));
            sum+=Integer.parseInt(String.valueOf(num.charAt(i)));
        }

        if(n%(product+sum)==0){
            return true;
        }else{
            return false;
        }
    }
}