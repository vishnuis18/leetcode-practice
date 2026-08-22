class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n=image.length;

        for(int[] arr: image){
            int first=0;
            int last=n-1;

            while(first<=last){
                int temp=arr[first]^1;
                arr[first]=arr[last]^1;
                arr[last]=temp;
                first++;
                last--;
            }
        }
        return image;
    }
}