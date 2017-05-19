package account.email;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetup;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.mail.Message;

import static org.junit.Assert.*;

/**
 * @author yfmei
 * @date 2017/5/19
 * @time 22:37
 */
public class AccountEmailServiceImplTest  {
    private GreenMail greenMail;

    @Before
    public void startMailServer() throws Exception {
        greenMail = new GreenMail(ServerSetup.SMTPS);
        greenMail.setUser("15996213405@163.com","11132221san777");
        greenMail.start();
    }

    @Test
    public void sendMail() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("account-email.xml");
        AccountEmailService accountEmailService = (AccountEmailService)ctx.getBean("accountEmailService");

        String subject = "test subject";
        String htmlText = "<h3>test</h3>";
        accountEmailService.sendMail("15996213405@163.com",subject,htmlText);
        //接受一封邮件最多不超过2秒，由于greenmail基于内存，基本不会超过两秒
        greenMail.waitForIncomingEmail(2000,1);
        //读取接收到的信息
        Message[] msgs = greenMail.getReceivedMessages();

        assertEquals(1,msgs.length);
        assertEquals(subject,msgs[0].getSubject());
        assertEquals(htmlText, GreenMailUtil.getBody(msgs[0]).trim());
    }

    @After
    public void tearDown() throws Exception {
        greenMail.stop();
    }

}