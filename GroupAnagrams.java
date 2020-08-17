class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> groupAnagrams(String[] strs) {
        // for(int i=0;i<strs.length;i++){
        //     char[] a = strs[i].toCharArray();
        //     Arrays.sort(a);
        //     strs[i]=new String(a);
        // }
        HashMap<String,List<Integer>> map = new HashMap<>();
        for(int j=0;j<strs.length;j++){
            String key = strs[j];
            char[] a = key.toCharArray();
            Arrays.sort(a);
            String str = new String(a);
            if(map.containsKey(str)){
                    List<Integer> x = map.get(str);
                    x.add(j);
                    map.put(str,x);
                }
                else{
                    List<Integer> x = new ArrayList<>();
                    x.add(j);
                    map.put(str,x);
                }
        }
        for(Map.Entry<String,List<Integer>> e : map.entrySet()){
            List<Integer> y = e.getValue();
            List<String> w = new ArrayList<>();
            for(int i=0;i<y.size();i++){
                w.add(strs[y.get(i)]);
            }
            Collections.sort(w);
            res.add(w);
        }
        return res;
    }
}