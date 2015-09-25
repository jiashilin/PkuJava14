public class Solution {
    public int myAtoi(String str) {
             if(str==null){
	            return 0;//如果字符串为空，返回0
	        }
	        str=str.trim();
	        int n=str.length();
	        if(n==0){
	            return 0;
	        }
	        int value=0;
	        boolean flag=false;
	        for(int i=0;i<n;i++){
	            if(i==0&&str.charAt(0)=='+'||i==0&&str.charAt(0)=='-'){
	                i++;
	                if(str.charAt(0)=='-'){
	                    flag=true;
	                }
	            }
	            if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
	            	int s=(int)(str.charAt(i)-'0');
	            	
	               
	                if(flag&&value<((Integer.MIN_VALUE+s)/10)){
	                    return Integer.MIN_VALUE;
	                }else if(!flag&&value>((Integer.MAX_VALUE-s)/10)){
	                     return Integer.MAX_VALUE;
	                }
	                
	                if(flag){
	            		 value=value*10-s;
	            	}else{
	            		 value=value*10+s;
	            	}
	            }else{
	                return value;
	            }
	        }
	        return value;
	        
	    }
}