class Solution {
    public int maxScore(int[] cardPoints, int k) {//if k==4, {left, right}{(0,4)(1,3)(2,2)(3,1)(4,0)}
        int n = cardPoints.length;
        int[] left = new int[n+1];
        int[] right = new int[n+1];
        left[0] = 0;
        for(int i=1;i<left.length;i++){
            left[i]=left[i-1]+cardPoints[i-1];
            // System.out.print(left[i]+" "); 
        }
        // System.out.println();
        right[n] = 0;
        for(int i=n-1;i>=0;i--){
            right[i]=right[i+1]+cardPoints[i];
            // System.out.print(right[i]+" ");
        }
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<=k;i++){
            ans = Math.max(ans,left[i]+right[n-k+i]);
        }
        return ans;
    }
}