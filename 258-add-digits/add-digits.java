class Solution {
    public int addDigits(int num) {
        String str = String.valueOf(num);
        while (String.valueOf(str).length() != 1) {
            int sum = 0;
            for (int i = 0; i < str.length(); i++) {
                sum += str.charAt(i) - '0';
            }
            str=String.valueOf(sum);

        }
        return Integer.parseInt(str);

    }
}