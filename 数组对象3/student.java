package 数组对象3;

public class student {
    private int id;
    private String name;
    private int age;
    //构造方法
    public student() {}
    public student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    //Javabean建立
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }




}
