import java.util.*;

class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int ans = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }

            boolean possible = true;

            for (int start = 0; start < n; start += k) {
                Map<Integer, Integer> freq = new HashMap<>();
                int descents = 0;

                for (int i = start; i < start + k; i++) {
                    freq.put(nums[i],
                        freq.getOrDefault(nums[i], 0) + 1);

                    freq.put(sorted[i],
                        freq.getOrDefault(sorted[i], 0) - 1);
                }

                for (int count : freq.values()) {
                    if (count != 0) {
                        possible = false;
                        break;
                    }
                }

                if (!possible) {
                    break;
                }

                for (int i = start; i < start + k - 1; i++) {
                    if (nums[i] > nums[i + 1]) {
                        descents++;
                    }
                }

                if (k > 1 && nums[start + k - 1] > nums[start]) {
                    descents++;
                }

                if (descents > 1) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                ans += k;
            }
        }

        return ans;
    }
}