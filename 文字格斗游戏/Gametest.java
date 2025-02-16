package 文字格斗游戏;

public class Gametest {
    public static void main(String[] args) {
        Role r1 = new Role("乔峰",100,'男');
        Role r2 = new Role("鸠摩智",100,'男');
        System.out.println("________________________________");
        r1.showinf();
        System.out.println("________________________________");
        r2.showinf();
        System.out.println("________________________________");
        while(r1.getHp()>0 && r2.getHp()>0) {
            r1.attack(r2);
            if(r2.getHp()>0){
                r2.attack(r1);
            }
        }
    }
}

