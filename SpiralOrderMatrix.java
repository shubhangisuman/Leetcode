class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length==0)
            return res;
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = n-1;
        int top = 0, bottom = m-1;
        while(true){
            if(left>right)
                break;
            for(int i=left;i<=right;i++){
                res.add(matrix[top][i]);
            }
            top++;
            if(top>bottom)
                break;
            for(int i=top;i<=bottom;i++){
                res.add(matrix[i][right]);
            }
            right--;
            if(left>right)
                break;
            for(int i=right;i>=left;i--){
                res.add(matrix[bottom][i]);
            }
            bottom--;
            if(top>bottom)
                break;
            for(int i=bottom;i>=top;i--){
                res.add(matrix[i][left]);
            }
            left++;

        }
        return res;
    }
}