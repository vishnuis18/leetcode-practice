import java.util.Arrays;

class Solution {
    public String smallestNumber(String num, long t) {
        // Step 1: Prime factorize t into 2^a * 3^b * 5^c * 7^d
        int a = 0, b = 0, c = 0, d = 0;
        long temp = t;

        while (temp % 2 == 0) { a++; temp /= 2; }
        while (temp % 3 == 0) { b++; temp /= 3; }
        while (temp % 5 == 0) { c++; temp /= 5; }
        while (temp % 7 == 0) { d++; temp /= 7; }

        // Prime factor other than 2, 3, 5, 7 -> impossible
        if (temp > 1) {
            return "-1";
        }

        int n = num.length();

        // Step 2: Check if num itself is valid
        if (!num.contains("0")) {
            int ra = a, rb = b, rc = c, rd = d;
            for (int i = 0; i < n; i++) {
                int digit = num.charAt(i) - '0';
                ra -= getFactor(digit, 2);
                rb -= getFactor(digit, 3);
                rc -= (digit == 5) ? 1 : 0;
                rd -= (digit == 7) ? 1 : 0;
            }
            if (ra <= 0 && rb <= 0 && rc <= 0 && rd <= 0) {
                return num;
            }
        }

        // Prefix factor counts in O(N) space and O(N) time
        int[] prefA = new int[n + 1];
        int[] prefB = new int[n + 1];
        int[] prefC = new int[n + 1];
        int[] prefD = new int[n + 1];

        int firstZero = num.indexOf('0');
        int maxPrefixLen = (firstZero == -1) ? n : firstZero;

        for (int i = 0; i < maxPrefixLen; i++) {
            int digit = num.charAt(i) - '0';
            prefA[i + 1] = prefA[i] + getFactor(digit, 2);
            prefB[i + 1] = prefB[i] + getFactor(digit, 3);
            prefC[i + 1] = prefC[i] + ((digit == 5) ? 1 : 0);
            prefD[i + 1] = prefD[i] + ((digit == 7) ? 1 : 0);
        }

        // Step 3: Try prefix matching from right to left
        for (int i = maxPrefixLen; i >= 0; i--) {
            int ra = a - prefA[i];
            int rb = b - prefB[i];
            int rc = c - prefC[i];
            int rd = d - prefD[i];

            int startDigit = (i == maxPrefixLen && firstZero != -1) ? 1 : (i < n ? num.charAt(i) - '0' + 1 : 1);

            for (int dNext = startDigit; dNext <= 9; dNext++) {
                int nra = ra - getFactor(dNext, 2);
                int nrb = rb - getFactor(dNext, 3);
                int nrc = rc - ((dNext == 5) ? 1 : 0);
                int nrd = rd - ((dNext == 7) ? 1 : 0);

                int remLen = n - 1 - i;
                if (remLen >= 0 && getMinLen(nra, nrb, nrc, nrd) <= remLen) {
                    StringBuilder sb = new StringBuilder(n);
                    sb.append(num, 0, i).append(dNext);
                    fillGreedyFast(sb, remLen, nra, nrb, nrc, nrd);
                    return sb.toString();
                }
            }
        }

        // Step 4: Fallback for length > n
        int minL = getMinLen(a, b, c, d);
        int targetLen = Math.max(n + 1, minL);
        StringBuilder sb = new StringBuilder(targetLen);
        fillGreedyFast(sb, targetLen, a, b, c, d);
        return sb.toString();
    }

    private int getFactor(int digit, int p) {
        if (p == 2) {
            if (digit == 8) return 3;
            if (digit == 4) return 2;
            if (digit == 2 || digit == 6) return 1;
        } else if (p == 3) {
            if (digit == 9) return 2;
            if (digit == 3 || digit == 6) return 1;
        }
        return 0;
    }

    // $O(1)$ Math formula for minimum length needed
    private int getMinLen(int ra, int rb, int rc, int rd) {
        ra = Math.max(0, ra);
        rb = Math.max(0, rb);
        rc = Math.max(0, rc);
        rd = Math.max(0, rd);

        int count = rc + rd;
        count += rb / 2;
        rb %= 2;

        count += ra / 3;
        ra %= 3;

        if (ra == 2 && rb == 1) { // 12 -> 2 and 6
            count += 2;
        } else if (ra == 1 && rb == 1) { // 6 -> 6
            count += 1;
        } else if (ra > 0 || rb > 0) {
            count += 1;
        }

        return count;
    }

    // $O(1)$ Direct calculation to append exact digit counts
    private void fillGreedyFast(StringBuilder sb, int length, int ra, int rb, int rc, int rd) {
        ra = Math.max(0, ra);
        rb = Math.max(0, rb);
        rc = Math.max(0, rc);
        rd = Math.max(0, rd);

        int c7 = rd;
        int c5 = rc;
        int c9 = rb / 2;
        rb %= 2;

        int c8 = ra / 3;
        ra %= 3;

        int c6 = 0, c4 = 0, c3 = 0, c2 = 0;

        if (ra == 2 && rb == 1) {
            c2 = 1; c6 = 1; // '2' and '6' for 12 (lexicographically smallest)
        } else if (ra == 1 && rb == 1) {
            c6 = 1;
        } else {
            if (rb == 1) c3 = 1;
            if (ra == 2) c4 = 1;
            if (ra == 1) c2 = 1;
        }

        int totalUsedDigits = c2 + c3 + c4 + c5 + c6 + c7 + c8 + c9;
        int c1 = length - totalUsedDigits; // Fill remaining space with '1's

        while (c1-- > 0) sb.append('1');
        while (c2-- > 0) sb.append('2');
        while (c3-- > 0) sb.append('3');
        while (c4-- > 0) sb.append('4');
        while (c5-- > 0) sb.append('5');
        while (c6-- > 0) sb.append('6');
        while (c7-- > 0) sb.append('7');
        while (c8-- > 0) sb.append('8');
        while (c9-- > 0) sb.append('9');
    }
}