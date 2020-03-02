package test18_threadpool_lambda.lambda;

/**
 * 无参数 无返回值
 */
public class InvokeCook {
    public static void main(String[] args) {
        invock(()-> System.out.println("吃饭啦"));
    }
    public static void invock(Cook cook){
        cook.makeFood();
    }
}
