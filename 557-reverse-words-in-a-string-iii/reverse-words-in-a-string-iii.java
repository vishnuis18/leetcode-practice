class Solution {
    public String reverseWords(String s) {
        String[] arr=s.split(" ");
        int n=arr.length;
        String[] ans=new String[n];

        for(int i=0;i<n;i++){
            StringBuilder str=new StringBuilder();
            for(int j=arr[i].length()-1;j>=0;j--){
                char ch=arr[i].charAt(j);
                str.append(ch);
            }
            ans[i]=str.toString();
        }

        StringBuilder answer=new StringBuilder();

        for(int k=0;k<n;k++){
            if(k<n-1){
                answer.append(ans[k]+" ");
            }else{
                answer.append(ans[k]);
            } 
        }
        return answer.toString();
    }
}