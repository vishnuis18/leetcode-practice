class Solution {
    public int countMonobit(int n) {
        
        String[] str = new String[n + 1];

        for (int i = 0; i <= n; i++) {
            str[i] = Integer.toBinaryString(i);
        }

        int count = 0;

        for (int j = 0; j <= n; j++) {
            for (int k = 0; k < str[j].length(); k++) {

                if (str[j].length() == 1) {
                    count++;
                    break;
                }

                if (str[j].length() >= 2 && str[j].charAt(k) == '1') {
                    if (k == str[j].length() - 1) {
                        count++;
                    }
                    continue;
                } else {
                    break;
                }
            }
        }

        return count;
    }
}