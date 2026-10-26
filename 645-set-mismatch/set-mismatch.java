import java.util.*;

class Solution {
    public int[] findErrorNums(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int duplicate = -1;
        int missing = -1;

        for (int i = 1; i <= n; i++) {
            if (map.getOrDefault(i, 0) == 2) {
                duplicate = i;
            } else if (map.getOrDefault(i, 0) == 0) {
                missing = i;
            }
        }

        return new int[]{duplicate, missing};
    }
}