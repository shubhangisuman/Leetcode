class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        int[] h1 = new int[26];
        int[] h2 = new int[26];
        // using two hashmaps
        for(int i=0;i<s.length();i++){
            h1[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t.length();i++){
            h2[t.charAt(i)-'a']++;
        }
        return Arrays.equals(h1,h2);
        //sort and compare
        //using single map
        for(int i=0;i<s.length();i++){
            h1[s.charAt(i)-'a']++;
            h1[t.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++){
            if(h1[i]!=0)
                return false;
        }
        return true;
    }
}