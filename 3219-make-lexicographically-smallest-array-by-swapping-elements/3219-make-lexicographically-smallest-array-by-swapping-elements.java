class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        HashMap<Integer, LinkedList<Integer>>group=new HashMap<>();
        HashMap<Integer,Integer>group_idx=new HashMap<>();
        int a[]=Arrays.copyOf(nums,nums.length);
        Arrays.sort(a);
        int group_num=0;
        group_idx.put(a[0],group_num);
        group.put(group_num,new LinkedList<>());
        group.get(group_num).add(a[0]);
        for(int i=1;i<a.length;i++){
            if(Math.abs(a[i]-a[i-1])>limit){
                group_num++;
            }
            group.putIfAbsent(group_num,new LinkedList<>());
            group.get(group_num).add(a[i]);
            group_idx.put(a[i],group_num);
        }
        int ans[]=new int[a.length];
        for(int i=0;i<a.length;i++){
            int groupnum=group_idx.get(nums[i]);
            int smallest_num=group.get(groupnum).pollFirst();
            ans[i]=smallest_num;
        }
    return ans;
    }
}