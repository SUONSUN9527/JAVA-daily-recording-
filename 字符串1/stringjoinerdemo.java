package 字符串1;

import java.util.StringJoiner;

public class stringjoinerdemo {
    public static void main(String[] args) {
        StringJoiner sj = new StringJoiner("---");
        StringJoiner sj1 = new StringJoiner(", ","[","]");
        //add
        sj.add("aaa").add("bbb").add("ccc").add("ddd");
        sj1.add("aaa").add("bbb").add("ccc").add("ddd");

        //length
        int len = sj1.length();

        //tostring
        String str = sj1.toString();



        System.out.println(sj);
        System.out.println(sj1);
        System.out.println(len);
        System.out.println(str);

    }
}
