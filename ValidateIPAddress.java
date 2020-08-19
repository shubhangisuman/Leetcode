class Solution {
    public boolean haveTrailingZeros(String s){
        int len = s.length();
        if(len == 1)
            return false;
        int c=0;
        for(int i=0;i<len;i++){
            if(s.charAt(i)!='0')
                break;
            c++;
        }
        if(c>0)
            return true;
        return false;
    }
    public boolean isIPv4(String s){
        if(!s.contains("."))
            return false;
        int l = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='.')
                l++;
        }
        if(l!=3)
            return false;
        if(s.length()>15)
            return false;
        String[] arr = s.split("\\.");
        if(arr.length!=4)
            return false;
        for(int i=0;i<arr.length;i++){
            boolean isInt = arr[i].matches("^[0-9]+$");
            if(!isInt)
                return false;
            System.out.println(isInt);
            int x = Integer.valueOf(arr[i]);
            if(!(x>=0 && x<=255))
                return false;
            if(haveTrailingZeros(arr[i]))
                return false;
        }
        return true;
    }
    public boolean isIPv6(String s){
        if(!s.contains(":"))
            return false;
        int l = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==':')
                l++;
        }
        if(l!=7)
            return false;
        if(s.length()>39)
            return false;
        String[] arr = s.split("\\:");
        if(arr.length!=8)
            return false;
        for(int i=0;i<arr.length;i++){
            int len = arr[i].length();
            if(!(len>=1 && len<=4))
                return false;
            boolean isHex = arr[i].matches("^[0-9a-fA-F]+$");
            if(!isHex)
                return false;
        }
        return true;
    }
    public String validIPAddress(String IP) {
        String res = "";
        if(isIPv4(IP)){
            res="IPv4";
        }
        else if(isIPv6(IP)){
            res="IPv6";
        }
        else{
            res="Neither";
        }
        return res;
   }
}


//Also see leetcode solutions
import java.net.*;
class Solution {
  public String validIPAddress(String IP) {
    try {
      return (InetAddress.getByName(IP) instanceof Inet6Address) ? "IPv6": "IPv4";
    } catch(Exception e) {}
    return "Neither";
  }
}

//Second leetcode solution
