package 字符串1;

import java.util.Scanner;

public class Str1 {
    public static void main(String[] args) {
        String rusername = "zhangsan";
        String rpassword = "123456";
        int i=0;
        boolean flag = false;
        while(i<3) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入用户名");
            String username = sc.next();
            System.out.println("请输入密码");
            String password = sc.next();

            if(rusername.equals(username) && rpassword.equals(password)) {
                System.out.println("用户登录成功");
                boolean flag1 = true;
                break;
            }else{
                System.out.println("傻逼密码错了");
                if(i<2){
                    System.out.printf("傻逼，你还有%s次机会\n",2-i);
                }else{}
            }
            i++;
        }
        if(!flag) {
            System.out.print("傻逼盗号狗，给爷死");
        }
    }
}
