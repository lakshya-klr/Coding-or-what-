class Solution {
    public boolean checkDivisibility(int n) {
        return n%(getsum(n)+getproduct(n)) ==0;
    }

    private int getsum(int n){
        int sum =0;
        int temp =0;
        while(n>0){
            sum += n%10;
            n=n/10;
        }
        return sum;
    }
    private int getproduct(int n){
        int prod =1 ;
        int temp =0;
        while(n>0){
            temp = n%10;
            n=n/10;
            prod = prod * temp;
        }
        return prod;
    }
}