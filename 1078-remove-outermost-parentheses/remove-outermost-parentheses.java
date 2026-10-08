class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder str = new StringBuilder();
        int depth = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                if (depth > 0) {
                    str.append(ch);
                }
                depth++;
            } else {
                depth--;
                if (depth > 0) {
                    str.append(ch);
                }
            }
        }

        return str.toString();
    }
}