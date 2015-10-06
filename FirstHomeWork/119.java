public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> relist=new ArrayList<Integer>(rowIndex);
		  if(rowIndex<0)
	        	return relist;
		  
		  for(int i=0;i<=rowIndex;i++){
			  relist.add(1);
	        	for(int j=i-1;j>0;j--){//从后往前进行遍历
	        		/* relist.add(1);
	        		if(j==0||j==i){
	        			//relist.add(1);
	        			relist.set(j, 1);
	        		}else{
	        			//relist.add(relist.get(j-1)+relist.get(j));
	        			relist.set(j, relist.get(j-1)+relist.get(j));
	        		}*/
	        		
	        		relist.set(j, relist.get(j-1)+relist.get(j));
	        	}
	        	
	        }
		return relist;
    }
}