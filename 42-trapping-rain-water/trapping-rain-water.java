import java.util.*;

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






















/*
class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int maxl=0;
        int maxr=0;
        int[] maxleft=new int[n];
        int[] maxright=new int[n];
        
        for(int i=0;i<n;i++){
            maxl=Math.max(height[i],maxl);
            maxleft[i]=maxl;
        }

        for(int i=n-1;i>=0;i--){
            maxr=Math.max(height[i],maxr);
            maxright[i]=maxr;
        }

        int totalwater=0;

        for(int i=0;i<n;i++){
            totalwater +=Math.min(maxleft[i],maxright[i])-height[i];
        }
        return totalwater;
    }
}
*/