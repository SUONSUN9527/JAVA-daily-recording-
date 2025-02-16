package 数组对象1;

public class saletest {
    public static void main(String[] args) {
        //1、创建数组
        sale[] aim = new sale[3];

        //2、创建三个商品对象
        sale s1 = new sale("001","huaweiP40",5999.0,100);
        sale s2 = new sale("002","cup",259.9,150);
        sale s3 = new sale("003","potato",4.2,1000);

        //3、添加至数组
        aim[0] = s1;
        aim[1] = s2;
        aim[2] = s3;

        //4、验证遍历输出
        for (int i = 0; i < aim.length; i++) {
            sale a = aim[i];
            System.out.println(a.getId()+","+a.getName()+","+a.getPrice()+","+a.getStorage());
        }
    }
}
