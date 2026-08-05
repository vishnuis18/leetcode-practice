class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        // Graph
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        int[] inDegree = new int[n];
        boolean[] suspicious = new boolean[n];

        // Build graph and indegree
        for (int[] edge : invocations) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            inDegree[v]++;
        }

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(k);
        suspicious[k] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int nbr : adj[curr]) {
                inDegree[nbr]--;

                if (!suspicious[nbr]) {
                    suspicious[nbr] = true;
                    queue.offer(nbr);
                }
            }
        }

        boolean cannotRemove = false;

        for (int i = 0; i < n; i++) {
            if (suspicious[i] && inDegree[i] > 0) {
                cannotRemove = true;
                break;
            }
        }

        List<Integer> result = new ArrayList<>();

        if (cannotRemove) {
            for (int i = 0; i < n; i++) {
                result.add(i);
            }
            return result;
        }

        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) {
                result.add(i);
            }
        }

        return result;
    }
}