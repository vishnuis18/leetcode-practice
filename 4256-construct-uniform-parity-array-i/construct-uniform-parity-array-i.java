class Solution {
    public boolean uniformArray(int[] nums1) {
        int ecount=0;
        int ocount=0;
        for(int i=0;i<nums1.length;i++){
            if(nums1[0]%2==0){
                ecount++;
            }else{
                ocount++;
            }
        }
        if(ecount==nums1.length){
            return true;
        }else if(ocount==nums1.length){
            return true;
        }else{
            return false;
        }
    }
}