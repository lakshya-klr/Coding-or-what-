class Solution {
    public long findScore(int[] nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<>(){
            public int compare(int[] a, int[] b){
                if(a[0]<b[0]) return -1;
                else if(a[0]>b[0]) return 1;
                return Integer.compare(a[1],b[1]);
            }
        });
        Set<Integer> marked = new HashSet<>();
        for(int i =0;i<nums.length;i++) pq.add(new int[]{nums[i],i});
        long score=0;
        while(!pq.isEmpty()){
            while(!pq.isEmpty() && marked.contains(pq.peek()[1])) pq.remove();
            if(pq.isEmpty()) break;
            int current[] = pq.remove();
            score+=current[0];
            marked.add(current[1]);
            if(current[1]-1>=0) marked.add(current[1]-1);
            if(current[1]+1<nums.length) marked.add(current[1]+1);
        }
        return score;
    }
}