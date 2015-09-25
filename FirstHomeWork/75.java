public class Solution {
    public void sortColors(int[] nums) {
          int[] color={0,0,0};
	        for(int i=0;i<nums.length;i++){
	        	if(nums[i]==0)
	        		color[0]++;
	        	if(nums[i]==1)
	        		color[1]++;
	        	if(nums[i]==2)
	        		color[2]++;
	        }
	        int j=0;
	        while(color[0]>0){
	        	nums[j]=0;
	        	j++;
	        	color[0]--;
	        }
	        while(color[1]>0){
	        	nums[j]=1;
	        	j++;
	        	color[1]--;
	        }
	        while(color[2]>0){
	        	nums[j]=2;
	        	j++;
	        	color[2]--;
	        }
    }
}