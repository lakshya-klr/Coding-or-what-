import java.util.*;

class Solution {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        // Find the minimum height and diameter of both trees
        int[] tree1 = findMinHeight(edges1.length + 1, edges1);
        int[] tree2 = findMinHeight(edges2.length + 1, edges2);

        // Calculate the minimum diameter after merging
        return Math.max(Math.max(tree1[1], tree2[1]), tree1[0] + tree2[0] + 1);
    }

    public int[] findMinHeight(int n, int[][] edges) {
        if (n <= 2) return new int[]{n - 1, n - 1};

        // Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Degree array to track the number of connections for each node
        int[] degree = new int[n];
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        // Initialize the queue with leaf nodes (degree 1)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) queue.add(i);
        }

        // Variables to track the height and the size of the last level
        int height = 0;
        int lastLevelSize = 0;

        // BFS to find the height of the tree
        while (!queue.isEmpty()) {
            int size = queue.size();
            lastLevelSize = size; // Store the size of the current level
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                for (int neighbor : adj.get(curr)) {
                    degree[neighbor]--;
                    if (degree[neighbor] == 1) {
                        queue.add(neighbor);
                    }
                }
            }
            height++;
        }

        // Adjust height and diameter based on the last level size
        height--; // The actual height of the tree
        int diameter = 2 * height;
        if (lastLevelSize > 1) {
            height++;
            diameter++;
        }

        return new int[]{height, diameter};
    }
}
