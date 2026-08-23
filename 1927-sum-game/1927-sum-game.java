class Solution {
    public boolean sumGame(String num) {
      int n = num.length();
        int leftknownsum =0;
        int rightknownsum=0;

        int leftqnmarkcount =0;
        int rightqnmarkcount =0;
        
        for(int i =0;i<n;i++){
            if(num.charAt(i)=='?'){
                if(i<n/2) leftqnmarkcount ++;
                else rightqnmarkcount++; 
            }
            else{
                 if(i<n/2) leftknownsum +=num.charAt(i)-'0';
                else rightknownsum+= num.charAt(i)-'0'; 
            }
        }

        int totalqnmarks = leftqnmarkcount + rightqnmarkcount ;

        if(totalqnmarks%2==1){
            //odd -> alice always wins
            return true;
        }

        int left = 2*leftknownsum + 9*leftqnmarkcount;
        int right = 2*rightknownsum + 9*rightqnmarkcount;

        return !(left==right);



    }
}