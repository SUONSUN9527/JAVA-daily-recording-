import java.util.Scanner;

public class method2 {
    public static void main(String[] args) {
        //求一个长方形的周长
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        Scanner sc1 = new Scanner(System.in);
        int width = sc1.nextInt();
        newmethod(width,len);
    }
    public static void newmethod(int wideth,int len) {
        int result = 2*(wideth+len);
        System.out.println(result);
    }
}
