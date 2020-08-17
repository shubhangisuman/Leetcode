class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public void helper(List<Integer> a,List<Integer> b){
        if(a.size()==0){
            // System.out.println(b);
            res.add(new ArrayList<>(b));
            // b.remove(b.size()-1);
            return;
        }
        else{
            for(int i=0;i<a.size();i++){
                b.add(a.get(i));
                List<Integer> y = new ArrayList<>();
                for(int j=0;j<a.size();j++){
                    if(j!=i)
                        y.add(a.get(j));
                }
                // System.out.println(y+"         "+b);
                helper(y,b);
                b.remove(b.size()-1);//**************backtracking
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length==0){
            res.add(new ArrayList<>());
            return res;
        }
        List<Integer> a = new ArrayList<>();
        for(int i=0;i<nums.length;i++)
            a.add(nums[i]);
        List<Integer> b = new ArrayList<>();
        helper(a,b);
        // for(int i=0;i<res.size();i++){
        //     System.out.println(res.get(i));
        // }
        return res;
    }
}