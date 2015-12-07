public class Solution {
    public boolean isAnagram(String s, String t) {
        /*if(s.length()!=t.length()){
		 		return false;
		 	}
		 	char[] ch=s.toCharArray();
		 	char[] ch1=t.toCharArray();
		 	int[] n=new int[26];		 	
		 	for(int i=0;i<ch.length;i++){
		 		n[ch[i]-97]++;
		 		n[ch1[i]-97]--;
		 	}
		 	for(int j=0;j<26;j++){
		 		if(n[j]!=0){
		 			return false;
		 		}
		 	}
	        return true;
			*/
		char[] sc=s.toCharArray();
        char[] tc=t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        if(sc.length!=tc.length){
        	return false;
        }else{
        	for(int i=0;i<sc.length;i++){
        		if(sc[i]!=tc[i]){
        			return false;
        		}
        	}
        }
        return true;
    }
}