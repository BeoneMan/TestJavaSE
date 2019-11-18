package test05_array;

//数组定义和访问
public class Array01 {
    public static void main(String[] args) {

    //数组的定义有三种方式
    int[] intArray01 = new int[16];
    int[] intArray02 = new int[]{1, 23, 5, 6};
    int[] intArray03 = {13, 23, 6, 2356, 6, 3};

        System.out.println(intArray01);
        System.out.println(intArray02);
        System.out.println(intArray03);

        System.out.println(intArray01[0]);
//        System.out.println(intArray01[16]);//ArrayIndexOutOfBoundsException
    }
}
