public class Solution {
    public boolean canWinNim(int n) {
        /*
        1个石子，先手全部拿走；
        2个石子，先手全部拿走；
        3个石子，先手全部拿走；
        4个石子，后手面对的是先手的第1，2，3情况，后手必胜；
        5个石子，先手拿走1个让后手面对第4种情况，后手必败；
        6个石子，先手拿走2个让后手面对第4种情况，后手必败；
        7个石子……
        容易看出来，只有当出现了4的倍数，先手无可奈何，其余情况先手都可以获胜。
        */
       if(n%4==0){
           return false;
       }else{
           return true;
       }
    }
}