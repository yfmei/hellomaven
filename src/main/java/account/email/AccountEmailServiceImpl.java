package account.email;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.security.auth.login.AccountException;

/**
 * @author yfmei
 * @description 接口的实现
 * @date 2017/5/19
 * @time 20:34
 */
public class AccountEmailServiceImpl implements AccountEmailService{
    //来自于spring framework的帮助简化邮件发送的工具类
    //用getter和setter实现依赖注入
    private JavaMailSender javaMailSender;
    private  String systemEmail;

    public void sendMail(String to, String subject, String htmlText) throws AccountEmailException {

        try {
            // 将要发送的邮件对象
            MimeMessage msg = javaMailSender.createMimeMessage();
            // 帮助设置邮件的发送地址，收件地址，主题和内容
            MimeMessageHelper msgHelper = new MimeMessageHelper(msg);

            msgHelper.setFrom(systemEmail);
            msgHelper.setTo(to);
            msgHelper.setSubject(subject);
            // true 表示html格式
            msgHelper.setText(htmlText, true);
            // 发送邮件
            javaMailSender.send(msg);
        } catch (MessagingException e) {
            throw new AccountEmailException("Failed to send mail.",e);
        }
    }

    public JavaMailSender getJavaMailSender() {
        return javaMailSender;
    }

    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public String getSystemEmail() {
        return systemEmail;
    }

    public void setSystemEmail(String systemEmail) {
        this.systemEmail = systemEmail;
    }
}
