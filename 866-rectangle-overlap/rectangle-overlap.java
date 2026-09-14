class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int width=Math.min(rec1[2],rec2[2])-Math.max(rec1[0],rec2[0]);
        int length=Math.min(rec1[3],rec2[3])-Math.max(rec1[1],rec2[1]);
        return width>0 && length>0;
    }
}

/*
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (rec1[0] >= rec2[2] || rec2[0] >= rec1[2]){
            return false;
        }
        if (rec1[1] >= rec2[3] || rec2[1] >= rec1[3]){
            return false;
        }
        return true;
    }
}
*/