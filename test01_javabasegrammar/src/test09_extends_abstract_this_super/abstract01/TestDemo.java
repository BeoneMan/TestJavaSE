package test09_extends_abstract_this_super.abstract01;


public class TestDemo {
    public static void main(String[] args) {
        AbstractAnimal animal=new Cat();
        System.out.println(animal.name);//多态 调用的是父类属性
        AbstractAnimal animal2=new Cat("Cat");
        System.out.println(animal2.name);

        animal.sleep();//重写父类方法
    }
}
