public class Solution {
    public int trailingZeroes(int n) {
        // int sum=1;
        // for(int i=n;i>0;i--){
        //     sum=sum*i;
        // }
        // int result=0;
        // while(sum/10>=10){
        //     if(sum%10==0){
        //         result++;
        //     }
        //     sum=sum/10;
        // }
        // return result;
        int result=0;
        while(n>4){
            result+=n/5;
            n/=5;
        }
        return result;
    }
}