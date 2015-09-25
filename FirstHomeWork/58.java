public class Solution {
    public int lengthOfLastWord(String s) {
         int re=0;
    	 String[] str=s.split(" ");
    	 int n=str.length;
    	 if(n<1){
    		 return re;
    	 }else{
    		 re=str[n-1].length();
    	 }
		return re;
    }
}