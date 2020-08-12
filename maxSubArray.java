class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if(nums.length==0)
            return 0;
        int cur_sum=0,max_sum=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            cur_sum=Math.max(cur_sum+nums[i],nums[i]);
            max_sum=Math.max(cur_sum,max_sum);
        }
        return max_sum;
    }
}