class Solution {
    public int minimumOperations(int[] nums) {
        int count;
        HashSet<Integer> set = new HashSet<>();
        int i =0;
        for( i =0;i<=nums.length;i+=3){
             count=0;
                set.clear();
            for(int j =i;j<nums.length;j++){
                set.add(nums[j]);
                count++;
            }
            
            if(set.size()==count) return i/3;
        }
        return i/3;
    }
}