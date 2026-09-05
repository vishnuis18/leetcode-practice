class Solution {
    public int minCostToMoveChips(int[] position) {
        int even=0;
        int odd=0;
        
        int n=position.length;
        for(int i=0;i<n;i++){
            if(position[i]%2==0){
                even++;
            }else{
                odd++;
            }
        }

        int answer=Math.min(even,odd);
        return answer;
    }
}


/*
class Solution {
    public int minCostToMoveChips(int[] position) {
        int n=position.length;
        HashMap<Integer,Integer> map=new HashMap<>();

        int min=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            map.put(position[i],map.getOrDefault(position[i],0)+1);
        }

        for(int key : map.keySet()){
            int cost=0;
            for(int pos : map.keySet()){
                if((key-pos)%2!=0){
                    cost+=map.get(pos);
                }
            }
            min=Math.min(min,cost);
        }
        return min;

    }
}
*/