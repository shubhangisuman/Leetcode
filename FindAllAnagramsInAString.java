class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> findAnagrams(String s, String p) {
        if(p.length()>s.length())
            return res;
        int[] h1 = new int[26];
        int[] h2 = new int[26];
        for(int i=0;i<p.length();i++){
            h1[s.charAt(i)-'a']++;
            h2[p.charAt(i)-'a']++;
        }
        int start=0;
        for(int i=p.length();i<s.length();i++){
            if(Arrays.equals(h1,h2))
                res.add(start);
            h1[s.charAt(i)-'a']++;
            h1[s.charAt(start)-'a']--;
            start++;
        }
        if(Arrays.equals(h1,h2))
            res.add(start);
        return res;
    }
}