public class Solution {
    public int climbStairs(int n) {
        /*if(n<=0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        
        return climbStairs(n-1)+climbStairs(n-2);*/
        int x=1,y=2;
        int re=0;
        if(n==1)
            re=x;
        if(n==2)
            re=y;
        for(int i=3;i<=n;i++){
            re=x+y;
            x=y;
            y=re;
        }
        
        return re;
    }
}