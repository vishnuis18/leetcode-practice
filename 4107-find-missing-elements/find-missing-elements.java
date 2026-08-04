import java.util.*;

class Solution {
    public List<Integer> findMissingElements(int[] nums) {

        Arrays.sort(nums);

        int first = nums[0];
        int last = nums[nums.length - 1];

        int length = (last - first) + 1;

        int[] arr = new int[length];

        for (int i = 0; i < length; i++) {
            arr[i] = first;
            first++;
        }

        HashSet<Integer> set = new HashSet<>();

        for (int x : nums) {
            set.add(x);
        }

        List<Integer> ans = new ArrayList<>();

        for (int x : arr) {
            if (!set.contains(x)) {
                ans.add(x);
            }
        }

        return ans;
    }
}