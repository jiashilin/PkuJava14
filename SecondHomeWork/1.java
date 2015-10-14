public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] re=new int[2];
        /*int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i<j){
                    if(nums[i]+nums[j]==target){
                        re[0]=i+1;
                        re[1]=j+1;
                        break;
                    }
                }
            }
        }*/
        //HashMap
         HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
	        for(int i=0;i<nums.length;i++){
	        	hm.put(nums[i], i);
	        }
	        for(int j=0;j<nums.length;j++){
	        	int temp=target-nums[j];
	        	if(hm.get(temp)!=null&&hm.get(temp)!=j){
	        		re[0]=j+1;
	        		re[1]=hm.get(temp)+1;
	        		break;
	        	}
	        }
        
        
        return re;
    }
}