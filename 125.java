public class Solution {
    public boolean isPalindrome(String s) {
    //�����Ǽ��һ���ַ������ȥ�����б����źͿո��Ƿ��ǻ����ַ���
    //���ȿ��ǿ��ַ�����������ǿյĶ���Ϊ���ַ���
    
    if(s == null) return false;
    if(s.replaceAll(" ","").equals("")) return true;
    
    //�ǿ�����°��ַ�������һ��arraylist�У�Ȼ�����β��ʼ����Ƚ�
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