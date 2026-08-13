class Solution {

    static class Node {
        int len;
        int pref;
        int suff;
        int best;
        char leftChar;
        char rightChar;

        Node() {}

        Node(int len, int pref, int suff, int best,
             char leftChar, char rightChar) {
            this.len = len;
            this.pref = pref;
            this.suff = suff;
            this.best = best;
            this.leftChar = leftChar;
            this.rightChar = rightChar;
        }
    }

    Node[] tree;
    char[] arr;

    Node merge(Node left, Node right) {

        if (left == null) return right;
        if (right == null) return left;

        Node res = new Node();

        res.len = left.len + right.len;

        res.leftChar = left.leftChar;
        res.rightChar = right.rightChar;

        // Prefix
        res.pref = left.pref;

        if (left.pref == left.len &&
            left.rightChar == right.leftChar) {
            res.pref = left.len + right.pref;
        }

        // Suffix
        res.suff = right.suff;

        if (right.suff == right.len &&
            left.rightChar == right.leftChar) {
            res.suff = right.len + left.suff;
        }

        // Best answer inside either half
        res.best = Math.max(left.best, right.best);

        // Possible substring crossing the middle
        if (left.rightChar == right.leftChar) {
            res.best = Math.max(
                res.best,
                left.suff + right.pref
            );
        }

        return res;
    }

    void build(int node, int l, int r) {

        if (l == r) {
            tree[node] = new Node(
                1,
                1,
                1,
                1,
                arr[l],
                arr[l]
            );
            return;
        }

        int mid = (l + r) / 2;

        build(2 * node, l, mid);
        build(2 * node + 1, mid + 1, r);

        tree[node] = merge(
            tree[2 * node],
            tree[2 * node + 1]
        );
    }

    void update(int node, int l, int r, int idx, char ch) {

        if (l == r) {
            tree[node] = new Node(
                1,
                1,
                1,
                1,
                ch,
                ch
            );
            return;
        }

        int mid = (l + r) / 2;

        if (idx <= mid) {
            update(2 * node, l, mid, idx, ch);
        } else {
            update(2 * node + 1, mid + 1, r, idx, ch);
        }

        tree[node] = merge(
            tree[2 * node],
            tree[2 * node + 1]
        );
    }

    public int[] longestRepeating(
        String s,
        String queryCharacters,
        int[] queryIndices
    ) {

        int n = s.length();
        int k = queryIndices.length;

        arr = s.toCharArray();

        tree = new Node[4 * n];

       
        build(1, 0, n - 1);

        int[] lengths = new int[k];

        for (int i = 0; i < k; i++) {

            int idx = queryIndices[i];
            char ch = queryCharacters.charAt(i);

            
            arr[idx] = ch;

            update(1, 0, n - 1, idx, ch);


            lengths[i] = tree[1].best;
        }

        return lengths;
    }
}