class Solution {
    public int missingMultiple(int[] nums, int k) {
        int sample = k;
        ArrayList<Integer> arr = new ArrayList<>();

        
        for (int num : nums) {
            arr.add(num);
        }
        int n = nums.length;
        int i=1;
        while (true) {
            if (arr.contains(sample)) {
                sample = k * i;
            } else {
                return sample;
            }
            i++;
        }
       

    }
}