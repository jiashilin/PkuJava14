public class Solution {
    public boolean isPalindrome(String s) {
    //本题是检测一个字符串如果去掉所有标点符号和空格是否是回文字符串
    //首先考虑空字符串现象，如果是空的定义为空字符串
    
    if(s == null) return false;
    if(s.replaceAll(" ","").equals("")) return true;
    
    //非空情况下把字符串放入一个arraylist中，然后从首尾开始逐个比较
    int a = s.length();
    ArrayList<String> temp1 = new ArrayList<String>();
    //ArrayList<String> temp2 = new ArrayList<String>();
    for(int i = 0; i < a; i++){
        int asc = s.charAt(i);
        if((asc >= 48 && asc <= 57) ||(asc >= 65 && asc <= 90) ||(asc >= 97 && asc <= 122)){
            temp1.add(String.valueOf(s.charAt(i)));
            //temp2.add(0,String.valueOf(s.charAt(i)));
        }
    }
    
    int b = temp1.size();
    //for(int j = 0; j < b; j++){
    //    if(temp1.get(j) != temp2.get(j)) return false;
    //}
    //return true;
    int j = 0;
    int k = b-1;
    while(j < k){
        if(temp1.get(j).toLowerCase().equals(temp1.get(k).toLowerCase())){
                j++;
                k--;
                }else{
                    return false;
                    }
                    }
                    return true;
    }
}