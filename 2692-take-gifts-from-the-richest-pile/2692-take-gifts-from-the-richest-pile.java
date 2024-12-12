class Solution {
    public long pickGifts(int[] gifts, int k) {
     Arrays.sort(gifts);
        int index=gifts.length-1;
     while(k>0){
        Arrays.sort(gifts);
        gifts[index]=(int)Math.floor(Math.sqrt(gifts[index]));
        

        k--;
     }   
     long sum=0;
     for(int i =0;i<gifts.length;i++){
        sum+=gifts[i];
     }
     return sum;
    }
}