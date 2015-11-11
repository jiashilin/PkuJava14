public class Solution {
    public String intToRoman(int num) {
        String[][] roman = {{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
            {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
            {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
            {"", "M", "MM", "MMM"}};
        
        String re = "";
        int i = 0;
        while (num != 0) {
            int  j = num % 10;
            re = roman[i][j] + re;
            i++;
            num =num/10;
        }
        
        return re;
    }
}