class Solution {
    private boolean[] isPrime(int n){
        boolean[] b = new boolean[n+1];
        for (int i = 2; i< b.length; i++) {
         b[i] = true;
        }

        for(int i=2; i<(Math.sqrt(n)+1); i++){
            if(b[i]==true) for(int j=i*i; j<(n+1); j+=i) b[j] = false;
        }
        return b;
    }
    public int[] closestPrimes(int left, int right) {
        boolean[] b = isPrime(right);
        int[] sol = new int[2];
        List<Integer> arr = new ArrayList<>();
        int smallest = Integer.MAX_VALUE;
        for(int i=left; i<=right; i++){
            if(b[i]==true){
                arr.add(i);
            }
        }
        if(arr.size()<2) return new int[]{-1, -1};
        for(int i=1; i<arr.size(); i++){
            int gap = arr.get(i) - arr.get(i-1);
            if(gap<smallest){
                smallest = gap;
                sol[0] = arr.get(i-1);
                sol[1] = arr.get(i);
            }
        }
        return sol;
    }
}