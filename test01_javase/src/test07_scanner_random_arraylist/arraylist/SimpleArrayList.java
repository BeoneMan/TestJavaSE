package test07_scanner_random_arraylist.arraylist;

public class SimpleArrayList<T> {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private T[] elements;

    public SimpleArrayList() {
        this.elements = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public SimpleArrayList(int capacity) {
        this.elements = (T[]) new Object[capacity];
    }

    //增
    public void add(T element) {
        add(size, element);
    }

    public void add(int index, T element) {
        checkArrayIndexAddAndSet(index);

        //扩容
        ensurecapacity();

        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = element;
        size++;

    }

    //删除
    public T remove(int index) {
        checkArrayIndexRemoveAndGet(index);
        T old = elements[index];
        for (int i = index; i < size; i++) {
            elements[index] = elements[index + 1];
        }
        elements[--size] = null;

        return old;
    }

    //改

    public void set(int index, T element) {
        checkArrayIndexAddAndSet(index);
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        elements[index] = element;
    }

    //查
    public T get(int index) {
        checkArrayIndexRemoveAndGet(index);
        return elements[index];
    }

    //实际元素
    public int getSize() {
        return this.size;
    }

    //数组越界检查[add set]
    public void checkArrayIndexAddAndSet(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
            }
        }

        //数组越界检查[remove get]
        public void checkArrayIndexRemoveAndGet(int index) {
            if (index < 0 || index >= size) {
                throw new ArrayIndexOutOfBoundsException();
            }
    }

    //扩容
    public void ensurecapacity(){
        if(size<elements.length){
            return;
        }
        int newcapacity=elements.length+(elements.length>>1);
        T[] newElement=(T[])new Object[newcapacity];

        for(int i=0;i<elements.length;i++){
            newElement[i]=elements[i];
        }
        elements=newElement;
    }


}
