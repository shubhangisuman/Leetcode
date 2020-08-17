class CombinationIterator {
    String s = "";
    TreeSet<String> a = new TreeSet<>();
    public void findCombination(int start,int len,String text,String s){
        if(len==0){
            a.add(text);
            return;
        }
        for(int i=start;i<s.length();i++){
            findCombination(i+1,len-1,text+s.charAt(i),s);
        }
    }
    public CombinationIterator(String characters, int combinationLength) {
        s+=characters;    
        // System.out.println(s);
        findCombination(0,combinationLength,"",s);
    }
    
    public String next() {
        return a.pollFirst();
    }
    
    public boolean hasNext() {
        if(a.size()>0)
            return true;
        return false;
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */