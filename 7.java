public class Solution {
    public int reverse(int x) {
    //һ���ܻ�������Ŀ��һ��������ת��ͬʱ���Ų���
    
    //������-10~10֮�䷵��ԭ��
    
    if(x > -10 && x < 10 ) return x;
    if(x == -2147483648) return 0;
    
    //���������Χ��ʱͨ���������Ĵ�������λ����ת
    
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