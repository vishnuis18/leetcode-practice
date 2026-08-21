class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> chars = Map.of(
            '(', ')',
            '{', '}',
            '[', ']'
        );

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (chars.containsKey(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty() || chars.get(stack.pop()) != ch) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}