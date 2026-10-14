import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> ans = new ArrayList<>();

        int n1 = nums1.length;
        int n2 = nums2.length;

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {

                if (nums1[i] == nums2[j]) {
                    ans.add(nums1[i]);
                    nums2[j] = -1;
                    break;
                }
            }
        }
        int[] result = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    }
}