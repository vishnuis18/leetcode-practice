class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        for (int i = 0; i < flowerbed.length && n > 0; i++) {

            if (flowerbed[i] == 0 &&
                (i == 0 || flowerbed[i - 1] == 0) &&
                (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {

                flowerbed[i] = 1;
                n--;
            }
        }
        return n == 0;
    }
}


/*class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int s=flowerbed.length;
        ArrayList<Integer> sample=new ArrayList<>();
        for(int num :flowerbed){
            sample.add(num);
        }
        if(n==0){
            return true;
        }

        for(int i=0;i<s;i++){
            if( sample.get(i)==0 && (i==0||sample.get(i-1)==0) && (i==s-1|| sample.get(i+1)==0)){
                sample.set(i,1);
                n--;
            }
            if(n==0){
                return true;
            }
        
        }
        
        return false;
    }
}
*/