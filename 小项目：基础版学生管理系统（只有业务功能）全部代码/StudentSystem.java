import java.util.ArrayList;
import java.util.Scanner;

public class StudentSystem {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        while (true) {
            System.out.println("------------------------欢迎来到黑马学生管理系统-------------------------");
            System.out.println("1：添加学生");
            System.out.println("2：删除学生");
            System.out.println("3：修改学生");
            System.out.println("4：查询学生");
            System.out.println("5：退出");
            System.out.println("请输入您的选择");
            Scanner sc = new Scanner(System.in);
            String choose = sc.next();
            if (choose.equals("5")) {
                break;
            }
            switch (choose){
                case "1"-> insertStudent(list);
                case "2"-> deleteStudent(list);
                case "3"-> updateStudent(list);
                case "4"-> searchStudent(list);
                case "5"-> System.out.println("退出");
                default -> System.out.println("傻逼有选项你不选,重选！");
            }
        }
    }
    //添加
    public static void insertStudent(ArrayList<Student> list){
        Student s = null;
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入ID");
            String id = sc.next();
            System.out.println("请输入姓名");
            String name = sc.next();
            System.out.println("请输入年龄");
            int age = sc.nextInt();
            System.out.println("请输入家庭住址");
            String address = sc.next();
            s = new Student(id, name, age, address);
            boolean flag = true;
            for (int i = 0; i < list.size(); i++) {
                Student student = list.get(i);
                String currentId = student.getId();
                if (currentId.equals(id)) {
                    System.out.println("该学生已经存在，添加失败,请重新添加");
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        list.add(s);
        System.out.println("添加成功");
    }

    //删除
    public static void deleteStudent(ArrayList<Student> list){
        System.out.println("请输入ID");
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        int index = getIndex(list, id);
        if (index == -1) {
            System.out.println("学生不存在");
            return;
        }
        list.remove(index);
        System.out.println("删除成功");
    }

    //修改
    public static void updateStudent(ArrayList<Student> list){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要修改学生的ID");
        String id = sc.next();
        int num = getIndex(list, id);
        if (num == -1) {
            System.out.println("学生不存在");
            return;
        }
        Student s = list.get(num);
        System.out.println("请输入姓名");
        String name = sc.next();
        System.out.println("请输入年龄");
        int age = sc.nextInt();
        System.out.println("请输入家庭住址");
        String address = sc.next();
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);
        System.out.println("修改成功！");
    }

    //查询
    public static void searchStudent(ArrayList<Student> list) {
        if(list.size() == 0){
            System.out.println("当前无学生信息，请添加后查询");
            return;
        }

        System.out.println("id\t\t\t姓名\t\t\t年龄\t\t\t家庭住址");
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            System.out.println(stu.getId()+"\t\t\t"+stu.getName()+"\t\t\t"+stu.getAge()+"\t\t\t"+stu.getAddress());
        }
    }


    //通过id获取索引
    public static int getIndex(ArrayList<Student> list,String id){
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            String sid = stu.getId();
            if(sid.equals(id)){
                return i;
            }
        }
        return -1;
    }



}
