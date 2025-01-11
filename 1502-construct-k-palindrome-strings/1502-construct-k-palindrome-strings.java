class Solution {
    public boolean canConstruct(String s, int k) {
        int n=s.length();
        if(s.length()<k){
            return false;
        }
        int arr[]=new int[26];
        for(int i=0;i<n;i++){
            arr[s.charAt(i)-'a']+=1;
        }
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2!=0){
                count ++;
            }
        }
        
        if(count>k){
            return false;
        }else{
            return true;
        }
    }
}