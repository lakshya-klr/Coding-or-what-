class Solution {
    public int findLucky(int[] arr) {
        int arr2[] = new int[501];
        for(int n :arr){
            arr2[n]+=1;
        }
        int result=-1;
        for(int i =1;i<501;i++){
            if(i==arr2[i]) result=i;
        }
        return result==0?-1:result;
    }
}