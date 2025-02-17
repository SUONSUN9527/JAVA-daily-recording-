package 字符串1;

import java.util.Scanner;

public class str2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入字符串");
        String str = sc.next();

        int bigCout = 0;
        int smallCout = 0;
        int numberCout = 0;
        for (int i = 0; i < str.length(); i++) {
            char c  = str.charAt(i);
            if(c >= 'a' && c <= 'z'){
                smallCout++;
            }else if(c >= 'A' && c <= 'Z'){
                bigCout++;
            }else if ((c >= '0' && c <= '9')) {
                numberCout++;
            }
        }
        System.out.println("小写字母共："+smallCout);
        System.out.println("大写字母共："+bigCout);
        System.out.println("数字共："+numberCout);
    }
}
