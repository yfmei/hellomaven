package account.email;

/**
 * @author yfmei
 * @description 发送邮件的接口
 * @date 2017/5/19
 * @time 20:31
 */
public interface AccountEmailService {
    /**
     * 发送邮件的接口
     * @param to 接收地址
     * @param subject 邮件主题
     * @param htmlText 邮件格式
     * @throws AccountEmailException 发送邮件出错抛出异常
     */
    void sendMail(String to, String subject, String htmlText)throws AccountEmailException;
}
