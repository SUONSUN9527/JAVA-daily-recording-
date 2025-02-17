package 字符串1;

public class 截取手机号码 {
    public static void main(String[] args) {
        String phonenumber = "13112349468";

        String start = phonenumber.substring(0,3);
        String end = phonenumber.substring(9,11);
        String result = start+"xxxx"+end;
        System.out.println(result);
    }
}
