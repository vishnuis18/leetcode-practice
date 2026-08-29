class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int k = t.length();

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < k; i++) {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int count = map.size();

        int i = 0;
        int j = 0;
        int start=0;

        int minlength = Integer.MAX_VALUE;

        while (j < n) {
            char cha = s.charAt(j);
            if (map.containsKey(cha)) {
                map.put(cha, map.get(cha) - 1);

                if (map.get(cha) == 0) {
                    count--;
                }
            }

            while (count == 0) {
                if (minlength > j - i + 1) {
                    minlength = j - i + 1;
                    start = i;
                }
                char left = s.charAt(i);
                if (map.containsKey(left)) {
                    map.put(left, map.getOrDefault(left, 0) + 1);
                    if (map.get(left) == 1) {
                        count++;
                    }

                }
                i++;
            }
            j++;
        }
        if (minlength == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(start, start + minlength);

    }
}