class Solution {
    public boolean isHappy(int n) {

        while (n >= 10) {
            String s = String.valueOf(n);

            int sum = 0;

            for (int i = 0; i < s.length(); i++) {
                int digit = s.charAt(i) - '0';
                sum += digit * digit;
            }

            n = sum;
        }

         return n == 1 || n == 7;
    }
}