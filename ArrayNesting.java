class Solution {
    public int helper(int num,int[] nums,int c,int start){
        if(num==start)
            return c;
        else
            return helper(nums[num],nums,c+1,start);
    }
    public int arrayNesting(int[] nums) {
        if(nums.length==0)
            return 0;
        int max = Integer.MIN_VALUE; 
        for(int i=0;i<nums.length;i++){
            max = Math.max(max,helper(nums[nums[i]],nums,1,nums[i]));
        }
        return max;
    }
}