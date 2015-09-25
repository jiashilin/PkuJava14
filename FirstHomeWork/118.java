public class Solution {
    public List<List<Integer>> generate(int numRows) {
       List<List<Integer>> reList=new ArrayList<List<Integer>>();

	        if(numRows==0)
	        	return reList;

	        for(int i=1;i<=numRows;i++){
	             List<Integer> list=new ArrayList<Integer>();
	        	for(int j=0;j<i;j++){
	        		if(j==0||j==i-1){
	        			list.add(1);
	        		}else{
	        			list.add(reList.get(i-2).get(j-1)+reList.get(i-2).get(j));
	        		}
	        		
	        	}
	        	reList.add(list);
	        }
			return reList;
    }
}