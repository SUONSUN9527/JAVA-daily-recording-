import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        ArrayList<User> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("欢迎来到学生管理系统");
            System.out.println("请选择操作：1登录 2注册 3忘记密码 4退出");
            String choose = sc.next();
            switch (choose) {
                case "1"-> login(list);
                case "2"-> register(list);
                case "3"-> forgetPassword(list);
                case "4"-> {
                    System.out.println("退出");
                            System.exit(0);
                }
                default -> System.out.println("傻逼有选项你不选，重选！");
            }
        }
    }

    //忘记密码
    private static void forgetPassword(ArrayList<User> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.next();
        boolean flag = checkRepeat(list, username);
        if (!flag) {
            System.out.println("未注册");
            return;
        }
        int index = findIndex(list, username);
        User user = list.get(index);
        System.out.println("请输入身份证号码");
        String personId = sc.next();
        boolean flag1 = checkRepeatPersonID(user, personId);
        if (!flag1) {
            System.out.println("账号信息不匹配，修改失败！");
            return;
        }else{
            System.out.println("请输入手机号码");
            String phoneNumber = sc.next();
            boolean flag2 = checkRepeatPhoneNumber(user, phoneNumber);
            if (!flag2) {
                System.out.println("账号信息不匹配，修改失败！");
                return;
            }else{
                while (true) {
                    System.out.println("请输入新密码");
                    String newPassword = sc.next();
                    System.out.println("请再次输入新密码");
                    String newPassword2 = sc.next();
                    if(newPassword.equalsIgnoreCase(newPassword2)){
                        System.out.println("修改成功！");
                        user.setPassword(newPassword);
                        break;
                    }else{
                        System.out.println("两次输入不一致！请重新输入新密码");
                        continue;
                    }
                }
            }
        }
    }

    //登录
    private static void login(ArrayList<User> list) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入用户名：");
            String username = sc.next();
            boolean flag1 = checkRepeat(list, username);
            if (!flag1) {
                System.out.println("用户名未注册");
                return;
            }
            while (true) {
                String rCode = getCode();
                System.out.println("请获取验证码");
                System.out.println("验证码为："+rCode);
                System.out.println("请输入验证码：");
                String code = sc.next();
                if(!code.equalsIgnoreCase(rCode)) {
                    System.out.println("验证码错误！请重新输入");
                    continue;
                }else{
                    System.out.println("验证码正确！");
                    break;
                }
            }
            System.out.println("请输入密码");
            String password = sc.next();
            //验证完验证码才能验证用户名密码
            User userinfo = new User(username,password,null,null);
            boolean flag2 = checkUserInfo(list,userinfo);
            if (!flag2) {
                if(i!=2){
                    System.out.println("用户名或密码错误！请重新输入");
                    System.out.println("您还剩"+(2-i)+"次机会");
                }else{
                    System.out.println("傻逼盗号狗，给爷死");
                    return;
                }
                continue;
            }else{
                System.out.println("登录成功！");
                //创建对象，调用方法，启动系统
                StudentSystem ss = new StudentSystem();
                ss.startStudentSystem();
                break;
            }
        }


    }

    private static boolean checkUserInfo(ArrayList<User> list, User userinfo) {
        String username = userinfo.getUsername();
        String password = userinfo.getPassword();
        for (int i = 0; i < list.size(); i++) {
            if(username.equalsIgnoreCase(list.get(i).getUsername())) {
                if(password.equalsIgnoreCase(list.get(i).getPassword())) {
                    return true;
                }
            }
        }
        return false;
    }

    //注册
    private static void register(ArrayList<User> list) {
        Scanner sc = new Scanner(System.in);
        User u = new User();
        //用户名
        while (true) {
            System.out.println("请输入用户名：");
            String name = sc.next();
            boolean flag = checkUsername(name);
            if (!flag) {
                System.out.println("用户名格式不满足条件，请重新输入！");
                continue;
            }
            boolean flag2 = checkRepeat(list, name);
            if (flag2) {
                System.out.println("用户名已存在，请重新输入！");
            }else{
                System.out.println("用户名可用！");
                u.setUsername(name);
                break;
            }
        }
        //密码
        while (true) {
            System.out.println("请输入密码");
            String password = sc.next();
            System.out.println("请再次输入密码");
            String rePassword = sc.next();
            if (password.equals(rePassword)) {
                System.out.println("设置成功！");
                u.setPassword(password);
                break;
            }else {
                System.out.println("两次输入不一致！请重新设置密码");
            }
        }
        //身份证
        while (true) {
            System.out.println("请输入身份证：");
            String personID = sc.next();
            boolean flag3 = checkPersonID(personID);
            if(!flag3){
                System.out.println("身份证输入不正确，请重新输入！");
                continue;
            }else{
                System.out.println("输入成功！");
                u.setPersonID(personID);
                break;
            }
        }
        //手机号
        while (true) {
            System.out.println("请输入手机号码：");
            String phoneNumber = sc.next();
            boolean flag4 = checkPhoneNumber(phoneNumber);
            if(!flag4){
                System.out.println("手机号码输入不正确！请重新输入！");
                continue;
            }else{
                System.out.println("输入成功！");
                u.setPhoneNumber(phoneNumber);
                break;
            }
        }
        list.add(u);
        System.out.println("注册成功！");
        printList(list);
    }

    private static void printList(ArrayList<User> list) {
        for (int i = 0; i < list.size(); i++) {
            User u = list.get(i);
            System.out.println(u.getUsername() + " " + u.getPassword() + " " + u.getPersonID() + " " + u.getPhoneNumber());
        }
    }

    public static boolean checkUsername(String username) {
        if (username.length() >15 || username.length() < 3) {
            return false;
        }
        for (int i = 0; i < username.length(); i++) {
            char ch = username.charAt(i);
            if (!((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9'))) {
                return false;
            }
        }
        int count = 0;
        for (int i = 0; i < username.length(); i++) {
            char ch = username.charAt(i);
            if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')){
                count++;
                break;
            }
        }
        return count>0;
    }

    public static boolean checkRepeat(ArrayList<User> list, String username) {
        for (int i = 0; i < list.size(); i++) {
            User u = list.get(i);
            String rName = u.getUsername();
            if (rName.equals(username)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkPersonID(String personID) {
        int len = personID.length();
        if (len != 18){
            return false;
        }
        char ch = personID.charAt(0);
        if (ch == '0') {
            return false;
        }
        for (int i = 1; i < len; i++) {
            char ch1 = personID.charAt(i);
            if (ch >'9' || ch <'0') {
                return false;
            }
        }
        char ch2 = personID.charAt(len - 1);
        if (((ch2 == 'x') || (ch2 == 'X') || ((ch2 >= '0') && (ch2 <= '9')))) {
            return true;
        }else{
            return false;
        }
    }

    public static boolean checkPhoneNumber(String phoneNumber) {
        int len = phoneNumber.length();
        if (len != 11){
            return false;
        }
        if (phoneNumber.startsWith("0")){
            return false;
        }
        for (int i = 0; i < len; i++) {
            char ch = phoneNumber.charAt(i);
            if (!((ch >= '0' && ch <= '9'))) {
                return false;
            }
        }
        return true;
    }

    //生成验证码
    public static String getCode(){
        Random rd = new Random();
        ArrayList<Character> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            list.add((char)('a' + i));
            list.add((char)('A' + i));
        }
        for (int i = 0; i < 4; i++) {
            int index = rd.nextInt(list.size());
            char c = list.get(index);
            sb.append(c);
        }
        int num = rd.nextInt(10);
        sb.append(num);
        char[] arr = sb.toString().toCharArray();
        int rIndex = rd.nextInt(arr.length);
        char temp = arr[rIndex];
        arr[rIndex] = arr[arr.length - 1];
        arr[arr.length - 1] = temp;

        String result = new String(arr);
        return result;
    }

    public static boolean checkRepeatPersonID(User user , String personID) {
        String rPersonID = user.getPersonID();
        if (rPersonID.equalsIgnoreCase(personID)) {
            return true;
        }
        return false;
    }

    public static boolean checkRepeatPhoneNumber(User user , String PhoneNumber) {
        String rPhoneNumber = user.getPhoneNumber();
        if (rPhoneNumber.equalsIgnoreCase(PhoneNumber)) {
            return true;
        }
        return false;
    }

    public static int findIndex(ArrayList<User> list, String username) {
        for (int i = 0; i < list.size(); i++) {
            User us = list.get(i);
            String usName = us.getUsername();
            if (usName.equalsIgnoreCase(username)) {
                return i;
            }
        }
        return -1;
    }

}
