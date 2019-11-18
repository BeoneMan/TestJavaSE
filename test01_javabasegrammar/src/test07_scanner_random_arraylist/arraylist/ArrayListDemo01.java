package test07_scanner_random_arraylist.arraylist;


public class ArrayListDemo01 {
    public static void main(String[] args) {
        SimpleArrayList<Person> arr = new SimpleArrayList<>();
        arr.add(new Person(18, "张三"));
        arr.add(new Person(28, "张三"));
        arr.add(new Person(38, "张三"));
        arr.add(new Person(15, "张四"));
        arr.add(new Person(18, "张三"));
        arr.add(new Person(28, "张三"));
        arr.add(new Person(38, "张三"));
        arr.add(new Person(15, "张四"));
        arr.add(new Person(18, "张三"));
        arr.add(new Person(28, "张三"));
        arr.add(new Person(38, "张三"));

        for (int i = 0; i < arr.getSize(); i++) {
            Person person = arr.get(i);
            String result = person.toString();
            System.out.println(result);
        }
    }
}
