class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int count=0;
        int i=0;
        int j=0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(i<g.length && j<s.length){
            if(g[i]<=s[j]){
                count++;
                i++;
                j++;
            }else{
                j++;
            }
        }
        return count;

    }
}

















/*
import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0; 
        int j = 0; 
        int count = 0;

        while (i < g.length && j < s.length) {

            if (s[j] >= g[i]) {
                count++;
                i++;
                j++;
            } else {
                j++;
            }
        }

        return count;
    }
}*/