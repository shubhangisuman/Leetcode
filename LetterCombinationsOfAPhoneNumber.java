class Solution {
    Map<String, String> phone = new HashMap<String, String>() {{
    put("2", "abc");
    put("3", "def");
    put("4", "ghi");
    put("5", "jkl");
    put("6", "mno");
    put("7", "pqrs");
    put("8", "tuv");
    put("9", "wxyz");
    }};
    List<String> comb = new ArrayList<>();
    public void backtrack(String digits,String res){
        if(digits.length()==0){
            comb.add(res);
            return;
        }
        else{
            String digit = digits.substring(0,1);
            String s = phone.get(digit);
            for(int i=0;i<s.length();i++){
                backtrack(digits.substring(1),res+s.charAt(i));
            }
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length()!=0)
            backtrack(digits,"");
        return comb;
    }
}