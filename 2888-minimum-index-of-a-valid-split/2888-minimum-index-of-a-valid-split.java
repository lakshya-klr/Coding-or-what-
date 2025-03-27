class Solution
{
    public int minimumIndex(List<Integer> nums)
    {
        int c = 0;
        int m = -1;
        int l = nums.size();

        for(int x : nums)
        {
            if(c==0)
            {
                m = x;
                c = 1;
            }

            else if(m==x)
                c++;

            else
                c--;
        }

        c = 0;

        for(int x : nums)
            if(x==m)
                c++;

        int x = 0;

        for(int i=0; i<l-1; i++)
        {
            if(nums.get(i)==m)
                x++;

            if(x*2>(i+1) && (c-x)*2>(l-i-1))
                return i;
        }

        return -1;
    }
}