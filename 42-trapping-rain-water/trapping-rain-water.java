class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int lmax=0;
        int rmax=0;

        int ans=0;
        int l=0;
        int r=n-1;
        while(l<r){

            lmax=Math.max(lmax,height[l]);
            rmax=Math.max(rmax,height[r]);
            if(lmax<rmax){
                ans+=lmax-height[l];
                l++;
            }else{
                ans+=rmax-height[r];
                r--;
            }
        }
        return ans;
    }
}





/*
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
*/