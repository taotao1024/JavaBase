package com.lsy.java8.mail;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.Security;
import java.util.Date;
import java.util.Properties;


/**
 * 阿里案例
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2020/11/17
 */
public class testSmtp {
    public static void main(String[] args) {
        try {
            //设置SSL连接、邮件环境
            Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
            Properties props = System.getProperties();
             props.setProperty("mail.smtp.host", "smtp.mxhichina.com");
//            props.setProperty("mail.smtp.host", "10.20.10.126");
            props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
            props.setProperty("mail.smtp.socketFactory.fallback", "false");
            // 端口：非加密25， ssl加密465
            props.setProperty("mail.smtp.port", "465");
            props.setProperty("mail.smtp.socketFactory.port", "465");
            props.setProperty("mail.smtp.auth", "true");
            //建立邮件会话
            Session session = Session.getDefaultInstance(props, new Authenticator() {
                //身份认证
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("cjzfyw@chanpay.com", "Aaaa1111");
                }
            });
            session.setDebug(true);
            //建立邮件对象
            MimeMessage message = new MimeMessage(session);
            //设置邮件的发件人、收件人、主题
            //附带发件人名字
            //message.setFrom(new InternetAddress("from_mail@qq.com", "optional-personal"));
            message.setFrom(new InternetAddress("cjzfyw@chanpay.com"));
            message.setRecipients(Message.RecipientType.TO, "1913475244@qq.com");
            message.setSubject("subject test");
            //文本
            String content = "mail content test";
            message.setText(content);
            message.setSentDate(new Date());
            message.saveChanges();
            //发送邮件
            Transport.send(message);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}
