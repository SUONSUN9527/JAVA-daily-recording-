package 字符串1;

public class StringBuilderdemo {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder("abc");
        //append
        sb.append(1);
        sb.append(2.3);
        sb.append(true);

        //reverse
        sb1.reverse();

        //length
        int len = sb.length();

        //tostring
        StringBuilder sb2 = new StringBuilder();
        sb2.append("aaa");
        sb2.append("bbb");
        sb2.append("ccc");
        sb2.append("ddd");
        String str = sb2.toString();

        System.out.println(sb2);//此时sb2不是字符串
        System.out.println(str);//此时已经转化为字符串

        System.out.println(len);
        System.out.println(sb);
        System.out.println(sb1);


    }
}
