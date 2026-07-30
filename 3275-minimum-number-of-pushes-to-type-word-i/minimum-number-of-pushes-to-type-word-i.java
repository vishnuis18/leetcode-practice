import java.util.Arrays;

class Solution {
    public int minimumPushes(String word) {

        Integer[] freq = new Integer[26];
        Arrays.fill(freq, 0);

        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }

        Arrays.sort(freq, java.util.Collections.reverseOrder());

        int result = 0;

        for (int i = 0; i < 26; i++) {
            int press = i / 8 + 1;
            result += press * freq[i];
        }

        return result;
    }
}


/*class Solution {
    public int minimumPushes(String word) {

        HashMap<Integer, Integer> map = new HashMap<>();
 
        for (int i = 2; i <= 9; i++) {
            map.put(i, 0);
        }

        int value=2;
        int result=0;
        for(char ch : word.toCharArray()){
            if(value>9){
                value=2;
            }
            map.put(value,map.get(value)+1);
            result+=map.get(value);
            value++;
        }
        return result;

    }
}
*/
/*
class Solution {
    public int minimumPushes(String word) {
        char[] first = {'a','b','c','d','e','p','t','w'};
        char[] second = {'f','h','j','l','n','q','u','x'};
        char[] third = {'g','i','k','m','o','r','v','y'};

        int sum = 0;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (contains(first, ch)) {
                sum += 1;
            } else if (contains(second, ch)) {
                sum += 2;
            } else if (contains(third, ch)) {
                sum += 3;
            } else {
                sum += 4;
            }
        }

        return sum;
    }

    public boolean contains(char[] arr, char ch) {
        for (char c : arr) {
            if (c == ch) {
                return true;
            }
        }
        return false;
    }
}
*/