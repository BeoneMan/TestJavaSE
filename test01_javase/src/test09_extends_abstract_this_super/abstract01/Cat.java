package test09_extends_abstract_this_super.abstract01;

public class Cat extends  AbstractAnimal {

    public Cat(){}
    public Cat(String name){
        super(name);
    }
    @Override
    void sleep() {
        System.out.println("cat睡觉");
    }

}
