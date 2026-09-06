class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
        int sum=0;
        int n=boxTypes.length;
        Arrays.sort(boxTypes,(a,b)->b[1]-a[1]);
        for(int i=0;i<n;i++){
            if(truckSize==0){
                break;
            }
            int boxes=Math.min(boxTypes[i][0],truckSize);

            sum=sum+(boxes*boxTypes[i][1]);
            truckSize-=boxes;
        }
        return sum;
    }
}


/*
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {

        int n = boxTypes.length;
        int m = boxTypes[0].length;
        int sum = 0;

        Arrays.sort(boxTypes,(a,b)->b[1]-a[1]);
        for (int i = 0; i < n; i++) {

            int units= boxTypes[i][1];
            int boxes=boxTypes[i][0];
            for (int l = 0; l < boxes; l++) {
                
                if(truckSize==0){
                    break;
                }
                sum+=units;
                truckSize--;
                
            }
            if(truckSize==0){
                break;
            }
        }
        return sum;
    }
}
*/