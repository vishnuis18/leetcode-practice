class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int k=p.length();
        int n=s.length();

        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<k;i++){
            map.put(p.charAt(i),map.getOrDefault(p.charAt(i),0)+1);
        }
        int count=map.size();

        ArrayList<Integer> ans=new ArrayList<>();

        int i=0;
        int j=0;
        while(j<n){
            if(map.containsKey(s.charAt(j))){
                map.put(s.charAt(j),map.get(s.charAt(j))-1);

                if(map.get(s.charAt(j))==0){
                    count--;
                }
            }
            if(j-i+1<k){
                j++;
            }else if(j-i+1==k){
                if(count==0){
                    ans.add(i);
                }

                if(map.containsKey(s.charAt(i))){
                    map.put(s.charAt(i),map.get(s.charAt(i))+1);
                    if(map.get(s.charAt(i))==1){
                        count++;
                    }
                }
                i++;
                j++;
            }
        }
        
        return ans;
    }
}