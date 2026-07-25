class Solution {
    public int maxProduct(int n) {
        int big =0;
        int secondbig = 0;
        while(n>0){
            int digit = n%10;
            if(digit>big){
                secondbig=big;
                big = digit;
            }
            else if(digit>secondbig){
                secondbig = digit;
            }
            n=n/10;
        }
            return big *secondbig;

    }
}