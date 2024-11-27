class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<Integer>[] adj =  new ArrayList[n];
        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < n - 1; i++) {
            adj[i].add(i + 1);
        }
        int[] ans = new int[queries.length];
        int idx = 0;
        for(int[] q : queries) {
            adj[q[0]].add(q[1]);
            ans[idx++] = f(adj, n);
        }

        return ans;
    }

    private int f(List<Integer>[] adj, int n) {
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        int ans = Integer.MAX_VALUE;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{0, 0});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currNode = curr[0];
            int currDist = curr[1];
            // System.out.println(Arrays.toString(curr));
            if(currNode == n - 1) {
                ans = Math.min(ans, currDist);
            }
            for(int nbr : adj[currNode]) {
                int nbrDist = currDist + 1;

                if(currDist + nbrDist < distance[nbr]) {
                    distance[nbr] = currDist + 1;
                    pq.offer(new int[]{nbr, distance[nbr]});
                }
            }
        }

        return ans;
    }
}