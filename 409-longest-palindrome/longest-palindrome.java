class Solution{
    public int longestPalindrome(String s){
        HashSet<Character> map=new HashSet<>();
        int count=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(map.contains(ch)){
                map.remove(ch);
                count+=2;
            }else{
                map.add(ch);
            }
        }
        if(!map.isEmpty()){
            count++;
        }
        return count;
    }
}

/*
class Solution {
    public int longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        int answer = 0;
        String ans = "";
        boolean odd = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ans.indexOf(ch) == -1) {
                ans += ch;
            }
        }

        for (int i = 0; i < ans.length(); i++) {
            int count = 0;

            for (int j = 0; j < s.length(); j++) {
                if (ans.charAt(i) == s.charAt(j)) {
                    count++;
                }
            }

            if (count % 2 == 0) {
                answer += count;
            } else {
                answer += count - 1;
                odd = true;
            }
        }

        if (odd) {
            answer++;
        }

        return answer;
    }
}
*/