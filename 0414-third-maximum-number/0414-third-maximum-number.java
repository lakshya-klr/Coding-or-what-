class Solution {
    public int thirdMax(int[] nums) {
        HashSet<Integer> set= new HashSet<>();
       for(int num:nums) set.add(num);
       int[] arr= new int[set.size()];
       int i =0;
        for(int num:set){
            arr[i]=num;
            i++;
        }
        Arrays.sort(arr);
        return arr.length>2?arr[arr.length-3]:arr[arr.length-1];
    }
}