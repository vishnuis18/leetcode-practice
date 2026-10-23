class Solution {
    public int trap(int[] height) {
        int n = height.length;

        ArrayList<Integer> lmax = new ArrayList<>();
        ArrayList<Integer> rmax = new ArrayList<>();

        int maxl = Integer.MIN_VALUE;
        int maxr = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            maxl = Math.max(maxl, height[i]);
            lmax.add(maxl);

            maxr = Math.max(maxr, height[n - 1 - i]);
            rmax.add(maxr);
        }

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += Math.min(lmax.get(i), rmax.get(n - 1 - i))- height[i];
        }

        return sum;
    }
}
