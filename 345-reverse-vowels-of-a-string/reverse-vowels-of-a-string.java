class Solution {
    public String reverseVowels(String s) {
        ArrayList<Character> vowels=new ArrayList<>();

        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'){
                vowels.add(ch);
            }
        }
        StringBuilder ans=new StringBuilder();
        int k=vowels.size()-1;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'){
                ans.append(vowels.get(k));
                k--;
            }else{
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}