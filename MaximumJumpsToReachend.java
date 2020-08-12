class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1 || nums[0]==0)
            return 0;
        int n = nums.length;
        int count[] = new int[n+1];
        Arrays.fill(count,Integer.MAX_VALUE);
        count[0]=0;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]+j>=i)
                    count[i]=Math.min(count[j]+1,count[i]);
            }
        }
        return count[n-1];
    }
}