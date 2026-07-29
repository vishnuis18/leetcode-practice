class Solution {
    public String smallestPalindrome(String s, int k) {
        int n = s.length();
        String middleChar = (n & 1) == 1 ? s.charAt(n >> 1) + "" : "";
        int[] freq = new int[26];

        for(int i = 0 ; i < (n >> 1) ; i++){
            freq[s.charAt(i) - 'a']++;
        }

        StringBuilder kThOrder = new StringBuilder("");

        for(int i = 0 ; i < (n >> 1) ; i++){
            boolean isCharPlaced = false;

            for(int j = 0 ; j < 26 ; j++){
                if(freq[j] == 0) continue;

                freq[j]--;

                long ways = exactWays(freq , (n / 2) - i - 1 , k);

                if(ways >= k){
                    kThOrder.append((char)(j + 'a'));
                    isCharPlaced = true;
                    break;
                }

                k -= ways;
                freq[j]++;
            }

            if(!isCharPlaced) return "";
        }

        return kThOrder.toString()
                + middleChar
                + new String(kThOrder.reverse());
    }

    private long nCr(long n , long r, long k){
        long ways = 1;

        for(int i = 1 ; i <= r ; i++){
            ways = ways * (n - r + i) / i;
            if(ways >= k) return k;
        }

        return ways;
    }

    private long exactWays(int[] freq , long n , long k){
        long ways = 1;
        int occupied = 0;

        for(int fi : freq){
            if(fi == 0) continue;

            ways = ways * nCr(n - occupied, fi , k);

            if(ways >= k) return k;

            occupied += fi;
        }

        return ways;
    }
}