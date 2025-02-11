import java.util.Random;

public class 打乱数据 {
    public static void main(String[] args) {
        //定义数组，存入12345，随机打乱数组中的数据
        //定义数组
        int []arr = {1,2,3,4,5};
        Random num = new Random();
        //随机交换
        for(int i=0;i<arr.length;i++) {
            int rand = num.nextInt(0,arr.length-1);
            while (i==rand){
                rand = num.nextInt(0,arr.length-1);
            }
            if(i!=rand) {
                int temp = arr[i];
                arr[i]=arr[rand];
                arr[rand]=temp;
            }
        }

        //输出
        for(int i=0;i<arr.length;i++) {
            System.out.println(arr[i]+" ");
        }
    }
}
