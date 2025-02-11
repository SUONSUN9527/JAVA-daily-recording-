public class exchangeindex1 {
    public static void main(String[] args) {
        //定义数组，存入12345，按照要求交换索引对应的元素
        //交换前：1,2,3,4,5
        //交换后：5,2,3,4,1

        //创建数组
        int [] arr1 = new int[]{1,2,3,4,5};
        //int[] arr1 = {1,2,3,4,5}这是简化算法

        //进行交换（索引从0开始）
        int a;//此处的a是第三方用来中转
        a = arr1[4];
        arr1[4] = arr1[0];
        arr1[0] = a;

        //输出交换结果
        for(int i=0; i<arr1.length; i++){
            System.out.println(arr1[i]);
        }
    }
}
