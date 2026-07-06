class Solution {
    public boolean detectCapitalUse(String word) {


        boolean allUpper = true;
        for (int i = 0; i < word.length(); i++) {
            if (!Character.isUpperCase(word.charAt(i))) {
                allUpper = false;
                break;
            }
        }
        if (allUpper) {
            return true;
        }

        boolean allLower = true;
        for (int i = 0; i < word.length(); i++) {
            if (!Character.isLowerCase(word.charAt(i))) {
                allLower = false;
                break;
            }
        }
        if (allLower) {
            return true;
        }

        if (Character.isUpperCase(word.charAt(0))) {
            boolean firstUpperRestLower = true;

            for (int i = 1; i < word.length(); i++) {
                if (!Character.isLowerCase(word.charAt(i))) {
                    firstUpperRestLower = false;
                    break;
                }
            }

            if (firstUpperRestLower) {
                return true;
            }
        }

        return false;
    }
}