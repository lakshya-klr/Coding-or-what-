//Logic: bitwiseAND => x & x = x (at best case)
//So, to get minCost we can take bitwiseAND of whole connected component of graph
class Solution {
    static ArrayList<Pair<Integer, Integer>> graph[];
    static boolean vis[];
    static int componentOfNode[];
    static ArrayList<Integer> componentValue;
    public static int dfsUtil(int node, int value, int bitwiseAND) {
        if(vis[node]) {
            return bitwiseAND;
        }

        componentOfNode[node] = value;
        vis[node] = true;
        for(Pair<Integer, Integer> x : graph[node]) {
            int neighbour = x.getKey();
            int weight = x.getValue();
            if(!vis[neighbour]) {
                bitwiseAND = dfsUtil(neighbour, value, bitwiseAND == -1 ? weight : bitwiseAND & weight);
            }
            bitwiseAND &= weight; //if same nodes have multiple edges
        }

        return bitwiseAND;
    }

    public static void dfs(int n) {
        vis = new boolean[n];
        componentOfNode = new int[n];
        componentValue = new ArrayList<>();
        int componentCount = 0;
        for(int i=0; i<n; ++i) {
            if(!vis[i]) {
                componentValue.add(componentCount, dfsUtil(i, componentCount, -1));
                ++componentCount;
            }
        }
    }

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        graph = new ArrayList[n];
        for(int i=0; i<n; ++i) {
            graph[i] = new ArrayList<>();
        }
        for(int e[] : edges) {
            graph[e[0]].add(new Pair(e[1], e[2]));
            graph[e[1]].add(new Pair(e[0], e[2]));
        }

        dfs(n);

        int m = query.length;
        int u = 0, v = 0;
        int res[] = new int[m];
        for(int i=0; i<m; ++i) {
            u = query[i][0];
            v = query[i][1];

            if(componentOfNode[u] != componentOfNode[v]) {
                res[i] = -1;
                continue;
            }

            res[i] = componentValue.get(componentOfNode[u]);
        }


        return res;
    }
}