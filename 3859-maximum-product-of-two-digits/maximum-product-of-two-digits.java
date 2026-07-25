import java.util.Arrays;

class Solution {
    public int maxProduct(int n) {
        String str = Integer.toString(n);
        int l = str.length();

        int[] arr = new int[l];

        for (int k = 0; k < l; k++) {
            arr[k] = Integer.parseInt(String.valueOf(str.charAt(k)));
        }

        Arrays.sort(arr);

        int sum = 0;

        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                int ans = arr[i] * arr[j];

                if (ans > sum) {
                    sum = ans;
                }
            }
        }

        return sum;
    }
}