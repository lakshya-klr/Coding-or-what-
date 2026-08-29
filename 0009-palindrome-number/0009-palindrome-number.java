class Solution {
    public boolean isPalindrome(int x) {
        int sum=0;
        int copy=x;
        while(x>0){
            int id=x%10;
            sum=sum*10+id;
            x=x/10;
        }
        if(sum == copy){ return true;}
        return false;
    }
}