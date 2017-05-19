package account.email;

/**
 * @author yfmei
 * @description
 * @date 2017/5/19
 * @time 21:12
 */
public class AccountEmailException extends Exception {

    public AccountEmailException(String message) {
        super(message);
    }

    public AccountEmailException(String message, Throwable cause) {
        super(message, cause);
    }
}
