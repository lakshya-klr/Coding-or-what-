class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
            // Step 1: Initialize reachability matrix
        boolean[][] reachable = new boolean[n][n];
        
        // Step 2: Populate direct prerequisites
        for (int[] pre : prerequisites) {
            reachable[pre[0]][pre[1]] = true;
        }
        
        // Step 3: Floyd-Warshall to calculate transitive closure
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (reachable[i][k] && reachable[k][j]) {
                        reachable[i][j] = true;
                    }
                }
            }
        }
        
        // Step 4: Answer each query
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(reachable[query[0]][query[1]]);
        }
        return result;
    }
    
}