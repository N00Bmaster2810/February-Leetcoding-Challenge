class Solution {
    class Pair<F, S> {
        public F first;
        public S second;

        Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }

        public F getFirst() {
            return this.first;
        }

        public S getSecond() {
            return this.second;
        }
    }
    public int shortestPathLength(int[][] graph) {
        if (graph.length <= 1)
            return 0;
        int n = graph.length;
        Queue<Pair<Integer, Pair<Integer, Integer>>> q = new LinkedList<>();
        boolean[][] seen = new boolean[n][1<<n];
        for (int i = 0; i < n; i++) {
            int mask = (1 << i);
            q.add(new Pair<>(i, new Pair<>(0, mask)));
            seen[i][mask] = true;
        }
        int end = (1 << n) - 1;
        while (!q.isEmpty()) {
            Pair<Integer, Pair<Integer, Integer>> p = q.poll();
            int node = p.first;
            int mask = p.second.second;
            int dist = p.second.first;
            for (int ch : graph[node]) {
                int newMask = mask | (1 << ch);
                if (newMask == end)
                    return dist + 1;
                if (!seen[ch][newMask]) {
                    q.add(new Pair<>(ch, new Pair<>(dist + 1, newMask)));
                    seen[ch][newMask] = true;
                }
            }
        }
        return 0;
    }
}