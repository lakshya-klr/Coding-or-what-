class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int xor1=0;
for(int i =0;i<nums1.length;i++){
    xor1=xor1^nums1[i];
}
 int xor2=0;
for(int i =0;i<nums2.length;i++){
    xor2=xor2^nums2[i];
}

int res=0;
if(nums1.length%2!=0) res^=xor2;
if(nums2.length%2!=0) res^=xor1;
return res;

    }
}