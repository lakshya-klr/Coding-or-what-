class Solution {
    public boolean checkPowersOfThree(int n) {
        int temp;
        while(n>3){
            temp=n%3;
            n=n/3;
            if(temp==2){
                return false;
            }
        }
        return n!=2?true:false;

    }
}