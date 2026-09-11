class Solution {
    public int totalNumbers(int[] digits) {

        int count = 0;
        for (int num = 100; num <= 999; num++) {      
            if (num % 2 != 0) {
                continue;
            }

            int a = num / 100;         
            int b = (num / 10) % 10;   
            int c = num % 10;           

            int[] need = new int[10];
            need[a]++;
            need[b]++;
            need[c]++;
            int[] have = new int[10];

            for (int digit : digits) {
                have[digit]++;
            }
            boolean possible = true;

            for (int i = 0; i < 10; i++) {
                if (need[i] > have[i]) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                count++;
            }
        }

        return count;
    }
}