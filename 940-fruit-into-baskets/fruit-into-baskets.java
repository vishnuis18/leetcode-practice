class Solution {
    public int totalFruit(int[] fruits) {
        int i = 0;
        int j = 0;
        int n = fruits.length;
        int k = 2;
        int maxlength = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (j < n) {
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
            while (map.size() > k) {
                int fruit = fruits[i];
                map.put(fruit, map.get(fruit) - 1);
                if (map.get(fruit) == 0) {
                    map.remove(fruit);
                }
                i++;
            }
            maxlength = Math.max(maxlength, j - i + 1);
            j++;
        }
        return maxlength;
    }
}