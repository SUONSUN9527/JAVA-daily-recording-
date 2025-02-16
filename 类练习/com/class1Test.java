package helm.com;

public class class1Test {
    public static void main(String[] args) {
        class1 obj = new class1();
        obj.age = 18;
        obj.gender = "male";
        obj.name = "fengponiang";
        System.out.println(obj.age);
        System.out.println(obj.gender);
        System.out.println(obj.name);
        System.out.println(obj);
        obj.sleep();
    }
}
