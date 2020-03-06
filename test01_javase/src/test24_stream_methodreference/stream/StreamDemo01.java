package test24_stream_methodreference.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo01 {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        System.out.println("list:"+list.stream());
        HashSet<Object> set = new HashSet<>();
        System.out.println("set:"+set.stream());
        HashMap<Object, Object> hashMap = new HashMap<>();
        System.out.println("hashmap:"+hashMap.entrySet().stream());

        int[] arrays=new int[10];
        Stream<int[]> arraysStream = Stream.of(arrays);
        System.out.println("arraysStream:"+arraysStream);
    }
}
