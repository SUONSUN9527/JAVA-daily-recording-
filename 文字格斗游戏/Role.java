package 文字格斗游戏;

import java.util.Random;

public class Role {
    private String name;
    private int hp;
    private char gender;
    private String face;//长相随机

    String[] boyfaces= {"风流俊雅","气宇轩昂","相貌英俊","五官端正","相貌平平","一塌糊涂","面目狰狞"};
    String[] girlfaces ={"美奂绝伦","沉鱼落雁","婷婷玉立","身材娇好","相貌平平","相貌简陋","惨不忍睹"};

    String[] attacks_desc={
            "%s使出了一招【背心钉】，转到对方的身后，一掌向%s背心的灵台穴拍去。",
            "%s使出了一招【游空探爪】，飞起身形自半空中变掌为抓锁向%s。",
            "%s大喝一声，身形下伏，一招【劈雷坠地】，捶向%s双腿。",
            "%s运气于掌，一瞬间掌心变得血红，一式【掌心雷】，推向%s。",
            "%s阴手翻起阳手跟进，一招【没遮拦】，结结实实的捶向%s。",
            "%s上步抢身，招中套招，一招【劈挂连环】，连环攻向%s。"
    };

    String[] injureds_desc={
            "结果%s退了半步，毫发无损",
            "结果给%s造成一处瘀伤",
            "结果一击命中，%s痛得弯下腰",
            "结果%s痛苦地闷哼了一声，显然受了点内伤",
            "结果%s摇摇晃晃，一跤摔倒在地",
            "结果%s脸色一下变得惨白，连退了好几步",
            "结果『轰』的一声，%s口中鲜血狂喷而出",
            "结果%s一声惨叫，像滩软泥般塌了下去"
    };

    public Role(String name, int hp, char gender) {
        this.name = name;
        this.hp = hp;
        this.gender = gender;
        setFace(gender);
    }
    public Role() {}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getFace() {
        return face;
    }

    public void setFace(char gender) {
        Random r = new Random();
        //长相随机
        if (gender == '男'){
            int index = r.nextInt(boyfaces.length);
            this.face = boyfaces[index];
        }else{
            int index = r.nextInt(girlfaces.length);
            this.face = boyfaces[index];
        }
    }

    public void attack(Role role){
        Random random = new Random();
        int index = random.nextInt(attacks_desc.length);
        String zhaoshi = attacks_desc[index];
        System.out.printf(zhaoshi,this.getName(),role.getName());

        int damage = random.nextInt(20)+1;
        int hp_new = role.getHp()-damage;
        if(hp_new<0){
            role.setHp(0);
        }else {
            role.setHp(hp_new);
        }
        if (hp_new>90){
            System.out.printf(injureds_desc[0],role.getName());
        } else if (hp_new>80) {
            System.out.printf(injureds_desc[1],role.getName());
        }else if (hp_new>70) {
            System.out.printf(injureds_desc[2],role.getName());
        }else if (hp_new>60) {
            System.out.printf(injureds_desc[3],role.getName());
        }else if (hp_new>40) {
            System.out.printf(injureds_desc[4],role.getName());
        }else if (hp_new>20) {
            System.out.printf(injureds_desc[5],role.getName());
        }else if (hp_new>10) {
            System.out.printf(injureds_desc[6],role.getName());
        }else{
            System.out.printf(injureds_desc[7],role.getName());
        }

        System.out.println(this.getName()+"对"+role.getName()+"造成了"+damage+"点伤害");
        System.out.println("此时："+role.getName()+"还剩下"+role.getHp()+"血量");
        System.out.println("此时："+this.getName()+"还剩下"+this.getHp()+"血量");
        System.out.println("________________________________");
        if(role.getHp()<=0){
            System.out.println(this.getName()+"把"+role.getName()+"揍死了");
        }
        if(this.getHp()<=0){
            System.out.println(role.getName()+"把"+this.getName()+"揍死了");
        }
    }

    public void showinf(){
        System.out.println("姓名："+getName());
        System.out.println("hp："+getHp());
        System.out.println("性别："+getGender());
        System.out.println("长相："+getFace());
    }
}
