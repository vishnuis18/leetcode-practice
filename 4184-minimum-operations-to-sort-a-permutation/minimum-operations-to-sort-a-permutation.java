class Solution {
    public int minOperations(int[] A) {
        int n = A.length;

        int asc = 1;
        int dsc = 1;

        for (int i = 1; i < n; i++) {

            if (A[i] == (A[i - 1] + 1) % n) {
                asc++;
            }

            if (A[i - 1] == (A[i] + 1) % n) {
                dsc++;
            }
        }

        if (asc == n) {
            if (A[0] == 0) {
                return 0;
            } else {
                int rotateOperations = n - A[0];
                int reverseOperations = A[0] + 2;

                return Math.min(rotateOperations, reverseOperations);
            }
        }

        if (dsc == n) {
            int rotateOperations = n - A[n - 1];
            int reverseOperations = A[n - 1];

            return Math.min(rotateOperations, reverseOperations) + 1;
        }

        return -1;
    }
}