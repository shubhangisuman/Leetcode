class Solution {
    public long binomialCoeff(int n,int k){
        if(k>n-k)
            k=n-k;
        long res=1;
        for(int i=0;i<k;i++){
            res*=(n-i);
            res/=(i+1);
        }
        return res;
    }
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        if(rowIndex==0){
            res.add(1);
            return res;
        }
        int n = rowIndex;
        for(int i=0;i<=n;i++){
            res.add((int)binomialCoeff(n,i));
        }
        return res;
    }
}