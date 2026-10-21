class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> ans1 = new ArrayList<>();
        int n2 = arr2.length;
        int n1 = arr1.length;
        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < n1; j++) {
                if (arr2[i] == arr1[j]) {
                    ans.add(arr1[j]);
                }
            }
        }

        for (int j = 0; j < n1; j++) {
            boolean found = false;
            for (int i = 0; i < n2; i++) {
                if (arr1[j] == arr2[i]) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                ans1.add(arr1[j]);
            }
        }

        Collections.sort(ans1);
        ans.addAll(ans1);
        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
}