package test14_list_set.list;

public class SimpleLinkedList<E> {
    int size;
    Node<E> head;
    Node<E> last;

    //remove


    //add(e);
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    //add(index ,e)
    public boolean add(int index, E e) {
        checkPositionIndex(index);
        if (index == size) {
            linkLast(e);
        } else {
            linkBefore(e, node(index));
        }
        return true;
    }

    private Node<E> node(int index) {
        Node<E> next = head;
        Node<E> prev = last;
        if (index < (size >> 1)) {
            for (int i = 0; i < index; i++) {
                next = next.next;
            }
            return next;

        } else {
            for (int i = size - 1; i > index; i--) {
                prev = prev.prev;
            }
            return prev;
        }

    }

    private void linkBefore(E e, Node<E> succ) {
        Node<E> succPrev = succ.prev;
        Node<E> newNode = new Node<>(succPrev, e, succ);
        succ.prev = newNode;
        if (succPrev == null) {
            head = newNode;
        } else {
            succPrev.next = newNode;
        }
        size++;

    }

    private void linkFirst(E e) {
        final Node<E> h = head;
        Node<E> newNode = new Node<E>(null, e, head);
        head = newNode;
        if (h == null) {
            last = newNode;
        } else {
            h.prev = newNode;
        }

    }

    private void checkPositionIndex(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("出错原因add(int index,E e)：index<0||index>size");
        }
    }


    private void linkLast(E e) {
        final Node<E> l = last;
        Node<E> newNode = new Node<E>(last, e, null);
        last = newNode;
        if (l == null) {
            head = newNode;
        } else {
            l.next = newNode;
        }

        size++;

    }


    static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.prev = prev;
            this.next = next;
        }

    }


    private int nextIndex;

    public boolean hasNext() {
        return nextIndex < size ? true : false;
    }

    public E next() {
        Node<E> returnNode=head;
        for(int i=0;i<nextIndex;i++){
            returnNode=returnNode.next;
        }
        ++nextIndex;
        return returnNode.item;
    }

}
