public class Solution {
    public int removeDuplicates(int[] nums) {
        	 int pre=0;
		 int next=1;
		 int count=0;
		 if(nums.length<=1){
			 return nums.length;
		 }
		 while(pre<next&&next<nums.length){
			 if(nums[pre]==nums[next]){
				 count++;
				 next++;
			 }else{
				 pre++;
				 nums[pre]=nums[next];
				 next++;
			 }
		 }
		return nums.length-count;	  
    }
}