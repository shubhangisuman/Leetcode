class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())
            return false;
        int n = s1.length();
        int[] hash1 = new int[26];
        int[] hash2 = new int[26];    //WINDOW SLIDING
        for(int i=0;i<s1.length();i++){
            hash1[s1.charAt(i)-'a']++;
            hash2[s2.charAt(i)-'a']++;
        }
        int s = 0; //Start of string
        for(int i=s1.length();i<s2.length();i++){
            if(Arrays.equals(hash1,hash2))
                return true;
            hash2[s2.charAt(s)-'a']--; //check if anagram or not
            hash2[s2.charAt(i)-'a']++;
            s++;
        }
        return Arrays.equals(hash1,hash2);
    }
}