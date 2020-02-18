package test16_exception_thread.exception;

/**
 * 要求：我们模拟注册操作，如果用户名已存在，则抛出异常并提示：亲，该用户名已经被注册。
 */
public class RegisterException extends Exception{
    public RegisterException() {
    }

    public RegisterException(String message) {
        super(message);
    }

}
