class Solution {
    public int reverseDegree(String s) {
        char[] arr=s.toCharArray();
        int sum=0;
        for(int i=0;i<arr.length;i++){
            char ch=arr[i];
            int n='z'-ch+1;
            int num=(i+1)*n;
            sum=sum+num;
        }
        return sum;
    }
}