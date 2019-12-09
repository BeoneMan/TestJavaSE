package test14_list_set.list;

public class TestDemo {
    public static void main(String[] args) {
        SimpleLinkedList<String> sll=new SimpleLinkedList<>();
        sll.add("Hello");
        sll.add("World");
        sll.add("Java");
        sll.add(1,"_");

        while(sll.hasNext()){
            System.out.print(sll.next());
        }
    }
}
