class Solution {
    public int compress(char[] chars) {
        ArrayList<String> ans=new ArrayList<>();
        int count=1;
        for(int i=1;i<chars.length;i++){
            if(chars[i]==chars[i-1]){
                count++;
            }else{
                if(count==1){
                    ans.add(chars[i-1]+"");
                }else{
                    ans.add(chars[i-1]+""+count);
                }
                count=1;
            }
        }
        if(count==1){
            ans.add(chars[chars.length-1]+"");
        }else{
            ans.add(chars[chars.length-1]+""+count);
        }

        String compressed = String.join("", ans);

        for (int i = 0; i < compressed.length(); i++) {
            chars[i] = compressed.charAt(i);
        }

        return compressed.length();
    }
}