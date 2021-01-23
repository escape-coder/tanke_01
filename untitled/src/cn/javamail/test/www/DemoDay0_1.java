package cn.javamail.test.www;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * @Package: cn.javamail.test.www
 * @ClassName: DemoDay0_1
 * @Author: Mr.Zhang
 * @CreateTime: 2021/1/22 14:16
 * @Description:JAVA 邮件
 */
public class DemoDay0_1 {


    public static void main(String[] args) throws MessagingException {
        Properties properties=new Properties();
        properties.setProperty("mail.smtp.auth","true");
        properties.setProperty("mail.transport.protocol","smtp");

        Session session=Session.getInstance(properties);
        session.setDebug(true);

        Message message=new MimeMessage(session);
        message.setFrom(new InternetAddress("z840231118@yeah.net"));
            message.setText("我不是垃圾邮件，请帮我转发一下!谢谢");
            message.setSubject("来自网易邮箱");
        Transport transport= null;

        try {
            transport = session.getTransport();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }
            transport.connect("smtp.yeah.net",25,"z840231118@yeah.net","此处填写网易smtp服务器给你账号的授权码");
        //如果用transport调send方法将直接完成一系列操作:new一个Transport对象，并和目标主机建立连接，再发送邮件，再释放资源
        //因为send方法是static类型的
        message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("840231118@qq.com"));
            transport.sendMessage(message,new Address[]{new InternetAddress("840231118@qq.com")});

        //释放连接
            transport.close();

    }

}
