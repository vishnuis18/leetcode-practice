import java.util.*;

class Solution {

    public String[] reorderLogFiles(String[] logs) {

        Arrays.sort(logs, (a, b) -> {

            String[] x = a.split(" ", 2);
            String[] y = b.split(" ", 2);

            boolean xDigit = Character.isDigit(x[1].charAt(0));
            boolean yDigit = Character.isDigit(y[1].charAt(0));

            if (xDigit && yDigit) {
                return 0;
            }

            if (xDigit) {
                return 1;
            }

            if (yDigit) {
                return -1;
            }

            int result = x[1].compareTo(y[1]);

            if (result == 0) {
                return x[0].compareTo(y[0]);
            }

            return result;
        });

        return logs;
    }
}