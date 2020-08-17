class Solution {
    public int longestPalindrome(String s) {
        if(s.length()==0)
            return 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i)))
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            else
                map.put(s.charAt(i),1);
        }
        int max=Integer.MIN_VALUE;
        int length=0;
        int f=1;
        for(Map.Entry<Character,Integer> e : map.entrySet()){
            int v = e.getValue();
            if(v%2==0){
                length+=v;
            }
            else{
                f=0;
                v--;
                length+=v;
            }
        }
        if(f==0)
            length++;
        return length;
    }
}