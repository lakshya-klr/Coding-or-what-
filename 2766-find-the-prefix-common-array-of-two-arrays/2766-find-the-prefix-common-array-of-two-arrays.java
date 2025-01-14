class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int ans[] = new int[A.length];
        int counter[] = new int[A.length+1];
        int n = A.length;
        for(int i =0;i<A.length;i++){
            counter[A[i]]++;
            counter[B[i]]++;
            ans[i]=checkcount(counter , n);
        }
        return ans;
    }
private int checkcount(int[] arr , int n){
    int count=0;
    for(int i =1;i<=n;i++){
        if(arr[i]==2) count++;
    }
    return count;
}
}