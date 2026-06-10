class Solution {
    public boolean isHappy(int n) {

        while (n >= 10) {
            String s = String.valueOf(n);

            ArrayList<String> list = new ArrayList<>();

            for (int i = 0; i < s.length(); i++) {
                list.add(String.valueOf(s.charAt(i)));
            }

            int sum = 0;

            for (int i = 0; i < list.size(); i++) {
                int digit = Integer.parseInt(list.get(i));
                sum += digit * digit;
            }

            n = sum;
        }

        return n == 1 || n == 7;
    }
}