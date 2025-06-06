class Solution {
    public int numOfSubarrays(int[] arr) {
        long count=0,sum=0,even=1,odd=0;
        int n=arr.length;
        final long m=1000000007;
        for(int i=0;i<n;i++)
        {
            sum+=arr[i];
            if(sum%2==1)
            {
                count+=even;
                odd++;
            }
            else
            {
                count+=odd;
                even++;
            }
            count%=m;
        }
        return (int)count;
    }
}