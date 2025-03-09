class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int gct = 0;
        int st = 0;
        int i = 0;
        while(st<n){

            if(colors[(i+n)%n] == colors[(i+1+n)%n]){
                st = i+1;
            }
            // length of window is i+2-st because we will check for i+1 index and starting from 0 so total length is i+2 and for window is i+2-st
            if(i+1+1-st == k){
                gct++;
                st++;
            }
            //System.out.println(i+" "+st+" "+gct);

            i++;
            
        }
        
        return gct;


        
    }
}