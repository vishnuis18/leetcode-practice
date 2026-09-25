class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);

        int left = 0;
        int max = 0;

        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > 1) {
                left++;
            }

            if (nums[right] - nums[left] == 1) {
                max = Math.max(max, right - left + 1);
            }
        }

        return max;
    }
}


/*class Solution {
    public int findLHS(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int num : nums) {
            list.add(num);
        }
        Collections.sort(list);

        int max = 0;
        int left = 0;

        for (int right = 0; right < list.size(); right++) {
            while (list.get(right) - list.get(left) > 1) {
                left++;
            }
            if (list.get(right) - list.get(left) == 1) {
                max = Math.max(max, right - left + 1);
            }
        }
        return max;
    }
}
*/
/*class Solution {
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
*/