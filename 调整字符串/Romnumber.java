package 调整字符串;

import 字符串1.str2;

public class Romnumber {
    public static void main(String[] args) {
        String A = "abcde";
        String B = "ebdca";
        int len = A.length();
        int i=0;
        while(i<len+1){
            String newA = rotate(A);
            A = newA;
            if(checkfun(newA,B)){
                System.out.println("True");
                break;
            }else{
                i++;
            }
        }
        if(i>len){
            System.out.println("你没机会了");
        }
    }

    public static String rotate(String str){
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < str.length(); i++){
            char c = str.charAt(i);
            sb.append(c);
        }
        sb.append(str.charAt(0));
        return sb.toString();
    }

    public static boolean checkfun(String str1, String str2){
        if(str1.equals(str2)){
            return true;
        }
        return false;
    }
}
