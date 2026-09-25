class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int num :nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        int max=0;

        for(int key: map.keySet()){
            if(map.containsKey(key+1)){
                int sum=map.get(key)+map.get(key+1);
                max=Math.max(sum,max);
            }
        }
        return max;

    }
}