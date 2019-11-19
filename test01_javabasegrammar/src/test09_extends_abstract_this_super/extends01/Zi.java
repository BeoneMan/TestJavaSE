package test09_extends_abstract_this_super.extends01;

public class Zi extends Fu {

    public Zi(String name){
       super(name);
    }
//    String name="儿子";

  @Override
    public void work() {
        System.out.println("儿子好好工作");
    }
}
