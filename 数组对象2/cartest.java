package 数组对象2;

import java.util.Scanner;

public class cartest {
    public static void main(String[] args) {
        car[] arr = new car[3];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("请输入brand");
            String brand = sc.next();
            System.out.println("请输入color");
            String color = sc.next();
            System.out.println("请输入price：");
            double price = sc.nextDouble();
            car c = new car();
            c.setBrand(brand);
            c.setColor(color);
            c.setPrice(price);
            arr[i] = c;
        }
        for (int i = 0; i < arr.length; i++) {
            car d = arr[i];
            System.out.println(d.getBrand()+" "+d.getColor()+" "+d.getPrice());
        }

    }
}
