class Solution {
    public int minimumPushes(String word) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Keys 2 to 9 initialized with 0
        for (int i = 2; i <= 9; i++) {
            map.put(i, 0);
        }

        int assignKey = 2;
        int result = 0;

        for (char ch : word.toCharArray()) {

            if (assignKey > 9) {
                assignKey = 2;
            }

            map.put(assignKey, map.get(assignKey) + 1);

            result += map.get(assignKey);

            assignKey++;
        }

        return result;
    }
}
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