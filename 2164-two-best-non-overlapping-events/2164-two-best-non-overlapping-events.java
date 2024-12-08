class Solution {
    public int maxTwoEvents(int[][] events) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        Arrays.sort(events,(a,b)->a[0]-b[0]);
        int prevmax=0;
        int res=0;
        for(int event[]:events){
            while(!pq.isEmpty() && pq.peek()[1]<event[0]){
                prevmax=Math.max(prevmax,pq.peek()[2]);
                pq.poll();
            }
            res=Math.max(res,prevmax + event[2]);
            pq.offer(event);
        }
return res;
    }
}