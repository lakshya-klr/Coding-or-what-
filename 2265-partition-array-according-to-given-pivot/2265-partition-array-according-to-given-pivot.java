class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int length = nums.length, index = 0;
        // Result array
        int[] result = new int[length];

        // To add all elements lesser than the pivot to the result
        for (int num: nums) if (num < pivot) result[index++] = num;

        // To add all elements equal to the pivot
        for (int num: nums) if (num == pivot) result[index++] = num;

        // To add all elements greater than the pivot to the result
        for (int num: nums) if (num > pivot) result[index++] = num;

        // Return result
        return result;
    }
}