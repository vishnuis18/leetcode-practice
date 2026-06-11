class Solution {
    public int titleToNumber(String columnTitle) {

        HashMap<Character,Integer> dict=new HashMap<>();

        for(char ch='A';ch<='Z';ch++){
            dict.put(ch,ch-'A'+1);
        }
        int sum=0;
        for(int i=0;i<columnTitle.length();i++){
            char chs=columnTitle.charAt(i);
            sum=sum*26+dict.get(chs);
        }
        return sum;


    }
}