公共 class exchangeindex2 {
    公共 static void main(String[] args) {
        //定义数组存入12345
        //交换前：12345
        //交换后：54321

        //定义数组
        int[]arr = new int[]{1，2，3，4，5};

        //进行交换（利用for loop）
        for(int i=0;i<arr.length;i++){
            if (i == arr.length-i-1){
                break;
            }
            int temp = arr[arr.length-i-1];
            arr[arr.length-i-1] = arr[i];
            arr[i] = temp;
        }
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
