public class Solution {
    public int removeElement(int[] nums, int val) {
         /*int length=nums.length;
	        for(int i=0;i<length;i++){
	        	if(nums[i]==val){
	        		length--;
	        	}
	        }
	          return length;*/
	          
	    int length=nums.length;
	        int j=length-1;
	        for(int i=0;i<=j;){
	        	if(nums[i]==val&&nums[j]==val){
	        		j--;
	        		length--;
	        	}else if(nums[i]==val){
	        		nums[i]=nums[j];
	        		i++;
	        		j--;
	        		length--;
	        	}else{
	        		i++;
	        	}
	        }
	          return length;
    }
}