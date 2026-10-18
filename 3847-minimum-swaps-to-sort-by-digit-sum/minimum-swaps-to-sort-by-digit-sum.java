import java.util.*;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int sum = 0;

            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            arr[i][0] = nums[i];
            arr[i][1] = sum;
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1];
            return a[0] - b[0];
        });

        int[] target = new int[n];
        for (int i = 0; i < n; i++) {
            target[i] = arr[i][0];
        }

        int[][] original = new int[n][2];
        for (int i = 0; i < n; i++) {
            original[i][0] = nums[i];
            original[i][1] = i;
        }

        Arrays.sort(original, (a, b) -> a[0] - b[0]);

        // Map each number to its original index
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < n; i++) {
            index.put(nums[i], i);
        }

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || target[i] == nums[i]) continue;

            int j = i;
            int cycle = 0;

            while (!visited[j]) {
                visited[j] = true;
                j = index.get(target[j]);
                cycle++;
            }

            if (cycle > 1) swaps += cycle - 1;
        }

        return swaps;
    }
}