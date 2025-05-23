class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);    // Sort tasks by difficulty
        Arrays.sort(workers);  // Sort workers by strength

        int left = 0;
        int right = Math.min(tasks.length, workers.length); // Max possible tasks

        // Binary search to find the maximum number of assignable tasks
        while (left < right) {
            int mid = (left + right + 1) / 2; // Try assigning 'mid' tasks
            if (canAssign(tasks, workers, pills, strength, mid)) {
                left = mid; // If possible, try more tasks
            } else {
                right = mid - 1; // Try fewer tasks
            }
        }

        return left; // Maximum number of tasks that can be assigned
    }

    // Helper to check if 'count' tasks can be assigned
    private boolean canAssign(int[] tasks, int[] workers, int pills, int strength, int count) {
        TreeMap<Integer, Integer> available = new TreeMap<>();

        // Add the strongest 'count' workers to the map
        for (int i = workers.length - count; i < workers.length; i++) {
            available.put(workers[i], available.getOrDefault(workers[i], 0) + 1);
        }

        // Assign the 'count' hardest tasks (i.e., highest strength required)
        for (int i = count - 1; i >= 0; i--) {
            int task = tasks[i];

            // Try to find a worker who can handle the task directly
            Integer worker = available.ceilingKey(task);
            if (worker != null) {
                decrementCount(available, worker);
            } else {
                // Use a pill and find a worker with base strength >= task - strength
                if (pills == 0) return false;
                worker = available.ceilingKey(task - strength);
                if (worker == null) return false;

                decrementCount(available, worker);
                pills--;
            }
        }

        return true;
    }

    // Decrease count or remove key from TreeMap
    private void decrementCount(TreeMap<Integer, Integer> map, int key) {
        int count = map.get(key);
        if (count == 1) {
            map.remove(key);
        } else {
            map.put(key, count - 1);
        }
    }
}