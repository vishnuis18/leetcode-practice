class Solution {
    public List<String> summaryRanges(int[] nums) {

        List<String> ans = new ArrayList<>();

        if (nums.length == 0) {
            return ans;
        }

        Arrays.sort(nums); 

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();

        current.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                current.add(nums[i]);
            } else {
                list.add(current);
                current = new ArrayList<>();
                current.add(nums[i]);
            }
        }

        list.add(current);

        for (ArrayList<Integer> temp : list) {
            if (temp.size() == 1) {
                ans.add(String.valueOf(temp.get(0)));
            } else {
                ans.add(temp.get(0) + "->" + temp.get(temp.size() - 1));
            }
        }

        return ans;
    }
}