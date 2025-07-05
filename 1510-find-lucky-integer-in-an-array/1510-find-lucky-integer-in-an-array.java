class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<arr.length;i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        // int[] arr2= new int[arr.length];
        int count=-1;
        for(int n : map.keySet()){
            if(map.get(n)==n){
                // arr2[count]=n;
                count=n;
            }
        }
        // Arrays.sort(arr2);
        // return (arr2[arr2.length-1]==0)?-1:arr2[arr2.length-1];
        return count;
        
    }
}