package test16_exception_thread.exception;

public class Demo01 {
    private String[] names = {"san", "yes", "driveman"};

    public static void main(String[] args) {
        Boolean driveman = new Demo01().checkName("driveman");
        System.out.println(driveman);
    }

    public Boolean checkName(String name) {
        if (name == null || name.length() == 0) return false;

        try {
            for (String strName : names) {
                if (name.equals(strName)) {
                    throw new RegisterException("用户已被注册");
                }
            }

        } catch (RegisterException e) {
            e.printStackTrace();
        }
        return true;
    }

}
