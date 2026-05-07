class Solution {
    public void duplicateZeros(int[] arr) {

        int[] temp = new int[arr.length];

        int j = 0;

        for (int i = 0; i < arr.length && j < arr.length; i++) {

            temp[j] = arr[i];
            j++;

           
            if (arr[i] == 0 && j < arr.length) {
                temp[j] = 0;
                j++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
    }
}