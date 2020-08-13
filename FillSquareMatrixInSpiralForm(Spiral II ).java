class Solution {
    public int[][] generateMatrix(int num) {
        int[][] matrix = new int[num][num];
        int m = num;
        int n = num;
        int left = 0, right = n-1;
        int top = 0, bottom = m-1;
        int c=1;
        while(true){
            if(left>right)
                break;
            for(int i=left;i<=right;i++){
                matrix[top][i]=c;
                c++;
            }
            top++;
            if(top>bottom)
                break;
            for(int i=top;i<=bottom;i++){
                matrix[i][right]=c;
                c++;
            }
            right--;
            if(left>right)
                break;
            for(int i=right;i>=left;i--){
                matrix[bottom][i]=c;
                c++;
            }
            bottom--;
            if(top>bottom)
                break;
            for(int i=bottom;i>=top;i--){
                matrix[i][left]=c;
                c++;
            }
            left++;

        }
        return matrix;
    }
}