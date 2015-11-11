public class Solution {
    public int romanToInt(String s) {
            int n=s.length();
		  int cur=Number(s.charAt(0)),sum=cur;
		  for(int i=1;i<n;i++){
			  if(Number(s.charAt(i))>Number(s.charAt(i-1))){
				  sum+=Number(s.charAt(i))-2*Number(s.charAt(i-1));
			  }else{
				  sum+=Number(s.charAt(i));
			  }			 
		  }
		return sum;	 
    }
    
    int Number(char ch){
		  int cur = 0;
		  switch(ch){
		  case 'M':
			  cur=1000;
			  break;
		  case 'D':
			  cur=500;
			  break;
		  case 'C':
			  cur=100;
			  break;
		  case 'L':
			  cur=50;
			  break;
		  case 'X':
			  cur=10;
			  break;
		  case 'V':
			  cur=5;
			  break;
		  case 'I':
			  cur=1;
			  break;			  
		  }
		  return cur;
	  }
    
}