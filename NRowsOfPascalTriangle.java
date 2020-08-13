class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        b.add(1);
        if(numRows==1){
            res.add(b);
            return res;
        } 
        int[][] dp = new int[numRows][numRows];
        for(int i=0;i<numRows;i++){
            for(int j=0;j<=Math.min(i,numRows);j++){
                if(i==j || j==0)
                    dp[i][j]=1;
                else
                    dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
            }
        }
        for(int i=0;i<numRows;i++){
            List<Integer> a = new ArrayList<>();
            for(int j=0;j<=i;j++){
                a.add(dp[i][j]);
            }
            res.add(a);
        }
        return res;
    }
}