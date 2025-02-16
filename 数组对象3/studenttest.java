package 数组对象3;

import java.util.Scanner;

public class studenttest {
    public static void main(String[] args) {
        student[] arr = new student[3];
        student s1 = new student(1,"zhangsan",23);
        student s2 = new student(2,"lisi",24);
        student s3 = new student(3,"wangwu",25);
        arr[0] = s1;
        arr[1] = s2;
        arr[2] = s3;

        //1、添加一个学生对象，并在添加的时候进行学号的唯一性判断
        student s4 = new student(4,"zhaoliu",26);
        boolean flag = contains(arr,s4.getId());
        if(flag){
            System.out.println("当前id错误,添加错误");
        }else{
            int count = getnum(arr);
            if(count == arr.length){
                int lenght = arr.length;
                student[] arr2 = getnewarray(arr);
                arr2[count] = s4;
                arr = arr2;
            }else{
                arr[count] = s4;
            }
        }

        //2、遍历所有学生信息
        printfun(arr);

        //3、通过id删除学生信息
        Scanner sc = new Scanner(System.in);
        int aimID = sc.nextInt();
        arr = deleteid(arr,aimID);

        //4、删除完毕后再次遍历所有学生信息
        printfun(arr);

        //5、查询数组id为“heima002”的学生，如果存在，将他的年龄+1
        Scanner sc1 = new Scanner(System.in);
        int aim1 = sc1.nextInt();
        arr = searchid(arr,aim1);
        printfun(arr);

    }
    //判断学号唯一性
    public static boolean contains(student[] arr, int id){
        for(int i=0;i<arr.length;i++){
            student temp=arr[i];
            if(temp!=null){
                int sid = temp.getId();
                if(sid==id){
                    return true;
                }
            }
        }
        return false;
    }
    public static int getnum(student[] arr) {
        int num = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] != null){
                num++;
            }
        }
        return num;
    }
    public static student[] getnewarray(student[] arr) {
        student[] arr2 = new student[arr.length+1];
        for(int i=0;i<arr.length;i++){
            arr2[i] = arr[i];
        }
        return arr2;
    }
    public static void printfun(student[] arr) {
        for(int i=0;i<arr.length;i++){
            if(arr[i] != null){
                System.out.println(arr[i].getId()+" "+arr[i].getName()+" "+arr[i].getAge());
            }
        }
    }
    public static student[] deleteid(student[] arr, int id) {
        boolean a = false;
        for(int i=0;i<arr.length;i++){

            if(arr[i] != null){
                if(arr[i].getId()==id){
                    arr[i]=null;
                    a = true;
                }
            }
        }
        if(!a){
            System.out.println("没有这个学生");
        }
        return arr;
    }
    public static student[] searchid(student[] arr, int id) {
        boolean a = false;
        for(int i=0;i<arr.length;i++){
            if (arr[i]!=null){
                if(arr[i].getId()==id){
                    arr[i].setAge(arr[i].getAge()+1);
                    a = true;
                }
            }
        }
        if(!a){
            System.out.println("该ID不存在，你个傻x");
        }
        return arr;
    }
}
