package test12objects_date_dateformat_calendar_system_stringbuilder.system;

import java.util.Arrays;

public class SystemDemo02 {
    public static void main(String[] args) {

        int[] oldArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int[] newArr = new int[20];
        System.out.println("转移之前" + Arrays.toString(newArr));

        System.arraycopy(oldArr, 0, newArr, 0, oldArr.length);
        System.out.println("转移之后" + Arrays.toString(newArr));

        //Arrays.copyOf()底层是调用 System.arraycopy();
 /*       public static <T,U> T[] copyOf(U[] original, int newLength, Class<? extends T[]> newType) {
            @SuppressWarnings("unchecked")
            T[] copy = ((Object)newType == (Object)Object[].class)
                    ? (T[]) new Object[newLength]
                    : (T[]) Array.newInstance(newType.getComponentType(), newLength);
            System.arraycopy(original, 0, copy, 0,
                    Math.min(original.length, newLength));
            return copy;
        }*/


    }
}
