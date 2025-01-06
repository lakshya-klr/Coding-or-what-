class Solution {
    public int[] minOperations(String boxes) {
        int temp=0;
        int[] ans= new int[boxes.length()];
        for(int i =0;i<boxes.length();i++){
            temp=0;
            for(int j=0;j<boxes.length();j++){
                if(i==j) continue;
                else{
                    if(boxes.charAt(j)=='1'){
                        temp+=Math.abs(i-j);
                    }
                }
            }
            ans[i]=temp;
        }
        return ans;
    }
}