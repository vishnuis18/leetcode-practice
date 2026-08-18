class Solution {
    public int largestInteger(int[] nums, int k) {

        ArrayList<int[]> subarrays = new ArrayList<>();

        for (int i = 0; i <= nums.length - k; i++) {
            int[] arr = new int[k];
            for (int j = 0; j < k; j++) {
                arr[j] = nums[i + j];
            }
            subarrays.add(arr);
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int[] sub : subarrays) {
                boolean found = false;
                for (int j = 0; j < sub.length; j++) {
                    if (nums[i] == sub[j]) {
                        found = true;
                        break;
                    }
                }
                if (found) {
                    count++;
                }
            }
            map.put(nums[i], count);
        }

        int ans = -1;
        for (int value : map.keySet()) {
            if (map.get(value) == 1) {
                if (value > ans) {
                    ans = value;
                }
            }
        }

        return ans;
    }
}