class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        
        HashSet<Integer> set1= new HashSet<>();
                HashSet<Integer> set2= new HashSet<>();
        

        int[] ans = new int[A.length];
        for(int i =0;i<A.length;i++){
            int count=0;
          set1.add(A[i]);
          set2.add(B[i]);
          for( int n : set1){
            if(set2.contains(n)) count++;
          }
          ans[i]=count;
        }
        return ans;
    }
}