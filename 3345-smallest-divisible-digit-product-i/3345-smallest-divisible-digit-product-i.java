class Solution {
    public int smallestNumber(int n, int t) {
       int prod = 1;
       int temp =n;
       
while(true){
    while (n>0){
        prod = prod * (n%10);
        n=n/10;
       } 
        if(prod%t == 0) return temp;
        else{
            n=temp+1;
            temp++;
            prod=1;
        }
}
    }
}