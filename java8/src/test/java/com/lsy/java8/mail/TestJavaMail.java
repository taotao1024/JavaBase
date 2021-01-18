package com.lsy.java8.mail;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import javax.xml.crypto.Data;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Properties;

/**
 * 不适用授权码
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2020/11/17
 */
public class TestJavaMail {

    /**
     * @param args
     * @throws Exception
     */
    /*public static void main(String[] args) throws Exception {
        Properties prop = new Properties();
        prop.setProperty("mail.host", "mail.yonyou.com");
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.auth", "true");
        //使用JavaMail发送邮件的5个步骤
        //1、创建session
        Session session = Session.getInstance(prop);
        //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
        session.setDebug(true);
        //2、通过session得到transport对象
        Transport ts = session.getTransport();
        //3、连上邮件服务器
        ts.connect("mail.yonyou.com", "cjzfyw@chanpay.com", "Aaaa1111");
        //4、创建邮件
        Message message = createSimpleMail(session);
        //5、发送邮件
        ts.sendMessage(message, message.getAllRecipients());
        ts.close();
    }*/

    /**
     * @param session
     * @return
     * @throws Exception
     * @Method: createSimpleMail
     * @Description: 创建一封只包含文本的邮件
     * @Anthor:孤傲苍狼
     */
    public static MimeMessage createSimpleMail(Session session)
            throws Exception {
        //创建邮件对象
        MimeMessage message = new MimeMessage(session);
        //指明邮件的发件人
        message.setFrom(new InternetAddress("cjzfyw@chanpay.com"));
        //指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("1913475244@qq.com"));
        //邮件的标题
        message.setSubject("只包含文本的简单邮件");
        //邮件的文本内容
        message.setContent("你好啊！", "text/html;charset=UTF-8");
        //返回创建好的邮件对象
        return message;
    }

    /**
     * @param session
     * @return
     * @throws Exception
     * @Method: createAttachMail
     * @Description: 创建一封带附件的邮件
     * @Anthor:孤傲苍狼
     */
    public static MimeMessage createAttachMail(Session session) throws Exception {
        MimeMessage message = new MimeMessage(session);

        //设置邮件的基本信息
        //发件人
        message.setFrom(new InternetAddress("gacl@sohu.com"));
        //收件人
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("cjzfyw@chanpay.com"));
        //邮件标题
        message.setSubject("JavaMail邮件发送测试");

        //创建邮件正文，为了避免邮件正文中文乱码问题，需要使用charset=UTF-8指明字符编码
        MimeBodyPart text = new MimeBodyPart();
        text.setContent("使用JavaMail创建的带附件的邮件", "text/html;charset=UTF-8");

        //创建邮件附件
        MimeBodyPart attach = new MimeBodyPart();
        DataHandler dh = new DataHandler(new FileDataSource("src\\2.jpg"));
        attach.setDataHandler(dh);
        attach.setFileName(dh.getName());  //

        //创建容器描述数据关系
        MimeMultipart mp = new MimeMultipart();
        mp.addBodyPart(text);
        mp.addBodyPart(attach);
        mp.setSubType("mixed");

        message.setContent(mp);
        message.saveChanges();
        //将创建的Email写入到E盘存储
        message.writeTo(new FileOutputStream("E:\\attachMail.eml"));
        //返回生成的邮件
        return message;
    }

    /**
     * 邮件发送
     * @throws Exception
     */
/*    @Override
    public void sendEmail(EmailSendMessageDto emailSendMessageDto) throws Exception {
        mailSender = new JavaMailSenderImpl();
        mailSender.setHost(emailSendMessageDto.getEmailHost());
        mailSender.setUsername(emailSendMessageDto.getEmailUserName());
        mailSender.setPassword(emailSendMessageDto.getEmailPassWord());
        mailSender.setDefaultEncoding("UTF-8");
        Properties pro = new Properties();
        pro.put("mail.smtp.auth", true);
        pro.put("mail.smtp.timeout", emailSendMessageDto.getTimeout());
        mailSender.setJavaMailProperties(pro);

        SimpleMailMessage message = new SimpleMailMessage();
        MimeMessage  mimeMessage  = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true,"GBK");
        messageHelper.setSubject(emailSendMessageDto.getTitle());//主题
        messageHelper.setText(emailSendMessageDto.getMessageContent(), true);//内容
        messageHelper.setFrom(emailSendMessageDto.getEmailFromUser());// 发送者
        messageHelper.setTo(emailSendMessageDto.getEmailToUser());// 接收者
        messageHelper.setSentDate(emailSendMessageDto.getSendTime());// 发送时间
//  MailMessageFactory message = new MailMessageFactory(SendMailType.HTML);
//  message.setSubject(emailSendMessageDto.getTitle());//主题
//  message.setText(emailSendMessageDto.getMessageContent());// 内容
//  message.setFrom(emailSendMessageDto.getEmailFromUser());// 发送者
//  message.setTo(emailSendMessageDto.getEmailToUser()); // 接收者
//  message.setSentDate(emailSendMessageDto.getSendTime());// 发送时间
        try {
            mailSender.send(mimeMessage);
        } catch (Exception e) {
            exceptionLogUtil.error(LOGGER, e);
        }
    }*/

    public static void sendEmail() throws Exception {

        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtp");  //smtp服务器
         // props.put("mail.smtp.host", "mail.chanpay.com");     //主机host
        props.put("mail.smtp.host", "smtp.mxhichina.com");     //主机host
        props.put("mail.smtp.auth", "true");    //
        // props.put("mail.smtp.port", "25");    //端口

        Session session = Session.getDefaultInstance(props, new Authenticator()
        {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("cjzfyw@chanpay.com","Aaaa1111");
            }
        });
        session.setDebug(true);
        Message message = createAttachMail2(session);
        Transport.send(message);

    }

    public static MimeMessage createAttachMail2(Session session)
            throws Exception {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress("cjzfyw@chanpay.com"));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("1913475244@qq.com"));
        message.setSubject("Test smtp.mxhichina.com Is Success");
        message.setContent(new Date() + "is Success ? ", "text/html;charset=UTF-8");
        return message;
    }

    public static void main(String[] args) throws Exception {
        sendEmail();
    }
}
