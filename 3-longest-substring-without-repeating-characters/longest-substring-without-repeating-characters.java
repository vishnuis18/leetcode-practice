class Solution {
    public int lengthOfLongestSubstring(String s) {

        int n=s.length();
        int i=0;
        int j=0;

        HashMap<Character,Integer> map=new HashMap<>();

        int maxlength=0;

        while(j<n){
            char ch=s.charAt(j);
            map.put(ch,j+1);

            if(map.size()==j-i+1){
                maxlength=Math.max(maxlength,j-i+1);
            }else if(map.size()<j-i+1){
                while(map.size()<j-i+1){
                    char left=s.charAt(i);
                    if(left!=ch){
                        map.remove(left);
                    }
                    i++;
                }
            }
            j++;
        }
        return maxlength;
    }
}