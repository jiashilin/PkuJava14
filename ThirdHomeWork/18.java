public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
       //可以先确定两个，然后再用2Sum的方法进行判断，O(n^3)时间复杂度.然后要注意
		//判重,采用HashSet进行判重
		List<List<Integer>> relist=new ArrayList<List<Integer>>();
		List<Integer> list=null;
		HashSet<List<Integer>> hs=new HashSet<List<Integer>>();
		if(nums.length<4){
			return relist;
		}
		Arrays.sort(nums);
		for(int i=0;i<nums.length;i++){
			for(int j=i+1;j<nums.length;j++){
				int k=j+1;
				int l=nums.length-1;
				while(k<l){
					int sum=nums[i]+nums[j]+nums[k]+nums[l];
					if(sum==target){
						list=new ArrayList<Integer>();
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[k]);
						list.add(nums[l]);
						if(!hs.contains(list)){
							hs.add(list);
							relist.add(list);
						}
						k++;
						l--;
					}else if(sum<target){
						k++;
					}else{
						l--;
					}
				}
				
				
			}
		}
		return relist;
    }
}