public class Solution {
    public int reverse(int x) {
    //一道很基础的题目将一个整数反转，同时符号不变
    
    //整数在-10~10之间返回原数
    
    if(x > -10 && x < 10 ) return x;
    if(x == -2147483648) return 0;
    
    //不再这个范围中时通过对余数的处理来将位数反转
    
    int y = 0;
    if(x > 0){
        y = x;
    }
    else{
        y = -x;
    }
    long n = 0;
    
    
    while(y / 10 >= 1){
        int last = y % 10;
        n = n * 10 + last;
        y = y/10;
    }
    
    //n = n + y;
    if(n * 10 <= 2147483640){
        n = n * 10 + y;
    }
    else n = 0;
    
    
    
    if(x < 0){
        n = 0-n;
    }
    //int r = int(n);
    int r = (int)n;
    return r;
    
    }
}