//1st Soluction(BFS Approach)
class Solution {

    public int[] numsSameConsecDiff(int N, int K) {

        if (N == 1)
            return new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        List<Integer> queue = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        for(int level = 1; level < N; ++ level) {
            ArrayList<Integer> nextQueue = new ArrayList<>();
            // iterate through each number within the level
            for (Integer num : queue) {
                Integer tailDigit = num % 10;

                ArrayList<Integer> nextDigits = new ArrayList<>();
                nextDigits.add(tailDigit + K);
                if (K != 0)
                    nextDigits.add(tailDigit - K);
                for (Integer nextDigit : nextDigits) {
                    if (0 <= nextDigit && nextDigit < 10) {
                        Integer newNum = num * 10 + nextDigit;
                        nextQueue.add(newNum);
                    }
                }
            }
            // prepare for the next level
            queue = nextQueue;
        }

        return queue.stream().mapToInt(i->i).toArray();
    }
}


//2nd Soluction(DFS Approach)
class Solution {
    ArrayList<Integer> a = new ArrayList<>();
    public int[] numsSameConsecDiff(int N, int K) {
        if(N==1)
            return new int[]{0,1,2,3,4,5,6,7,8,9};
        for(int i=1;i<=9;i++)
            dfs(N,K,i,0,i);
        int[] res = new int[a.size()];
        for(int i=0;i<a.size();i++)
            res[i]=a.get(i);
        return res;
    }
    public void dfs(int n,int k,int cur,int i,int prv){
        if(i==n-1){
            a.add(cur);
            return;
        }
        int next = prv+k;
        if(next<10){
            dfs(n,k,(cur*10)+next,i+1,next);
        }
        next = prv-k;
        if(k!=0 && next>=0){
            dfs(n,k,(cur*10)+next,i+1,next);
        }
    }
}