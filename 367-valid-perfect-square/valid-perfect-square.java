class Solution {
    public boolean isPerfectSquare(int num) {

        //long i = 1;

        
        double n = Math.sqrt(num);
        if(n==(int)n){
            return true;
        }else{
            return false;
        }
    }
}
