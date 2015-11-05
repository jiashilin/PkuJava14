public class Solution {
    public int majorityElement(int[] nums) {
        int count=1;
        int temp=nums[0];
        for(int i=1;i<nums.length;i++){
             if(count==0){
                temp=nums[i];
            }
            if(temp!=nums[i]){
                count--;
            }
             if(temp==nums[i]){
                count++;
            }
            
        }
        return temp;
    }
}