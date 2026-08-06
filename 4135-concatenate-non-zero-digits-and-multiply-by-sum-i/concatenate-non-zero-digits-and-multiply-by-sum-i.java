class Solution {
    public long sumAndMultiply(int n) {
        ArrayList<String> ans=new ArrayList<>();
        String str=Integer.toString(n);
        char[] chars=str.toCharArray();

        int sum=0;
        for(int i=0;i<chars.length;i++){

            sum+=chars[i]-'0';
            if(chars[i]!='0'){
                ans.add(chars[i]+"");
            }
        }

        String st=String.join("",ans);
        int m=st.isEmpty() ? 0 : Integer.parseInt(st);
        return (long) m*sum;
    }
}