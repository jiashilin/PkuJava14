public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       //由于已经做过两个数的和，因此三个数的和只要将数组从头遍历一遍，对于每个数然后再采用两个数的形式即可求得
		List<List<Integer>> relist=new ArrayList<List<Integer>>();		
		List<Integer> list = null;
		int i,j;
		Arrays.sort(nums);
		for(int k=0;k<nums.length;k++){	
			if(k!=0&&nums[k]==nums[k-1])
				continue;
			 i=k+1;
			 j=nums.length-1;
			 int sum=0;
			 while(i<j){
				 sum=nums[i]+nums[j]+nums[k];
				 if(sum==0){
					 list=new ArrayList<Integer>();
					 list.add(nums[k]);
					 list.add(nums[i]);
					 list.add(nums[j]);
					 relist.add(list);
					 
					 while(++i<j&&nums[i-1]==nums[i]){
						 
					 }
					 while(--j>i&&nums[j+1]==nums[j]){
						 
					 }
				 }else if(sum<0){
					 i++;
				 }else{
					 j--;
				 }
			 }
		}
		return relist;
    }
}