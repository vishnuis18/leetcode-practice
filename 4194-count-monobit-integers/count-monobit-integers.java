class Solution {
    public int countMonobit(int n) {
        
        int count = 1;
        int x = 0;

        while (true) {

            x = (x << 1) | 1;

            if (x > n) {
                break;
            }

            count++;
        }

        return count;
    }
}