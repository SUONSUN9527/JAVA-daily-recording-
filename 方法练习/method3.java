import java.util.Scanner;

public class method3 {
    public static void main(String[] args) {
        //求圆的面积
        Scanner sc = new Scanner(System.in);
        double r = sc.nextDouble();
        get_sqr(r);
    }
    public static void get_sqr(double r) {
        double a = 3.14*r*r;
        String result = String.format("%.3f",a);
        Double b = Double.valueOf(result);
        System.out.println(b);}
}
