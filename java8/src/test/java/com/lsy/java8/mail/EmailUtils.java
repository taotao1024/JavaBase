package com.lsy.java8.mail;

import org.junit.Test;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;

/**
 * 邮箱工具
 *
 * @author yuanyuan
 * @version 1.0
 * @date 2020/11/16
 */
public class EmailUtils {
    /**
     * 邮箱的SMTP功能都是默认关闭的，需要自己开启，并获取授权码
     * POP3、SMTP 授权码
     */
    static String authorizationCode = "";

    //参数分别为收件人的邮箱，邮件标题，邮件内容
    public static void sendEmail(String sendUser, String title, String content) throws MessagingException {
        // 0、配置发送邮件的环境属性
        final Properties props = new Properties();
        // 表示SMTP发送邮件，需要进行身份验证
        props.put("mail.smtp.auth", "true");//需要验证
        props.put("mail.smtp.host", "smtp.qq.com");//邮箱的服务器，qq的就是smtp.qq.com，163的是smtp.163.com
        props.put("mail.user", "1913475244@qq.com");// 发件人的账号
        props.put("mail.password", authorizationCode);// 访问SMTP服务时需要提供的密码

        // 构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };

        // 1、使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);
        // 2、创建邮件消息 Message对象实例代表一封电子邮件
        MimeMessage message = new MimeMessage(mailSession);
        // 设置发件人
        InternetAddress form = new InternetAddress(props.getProperty("mail.user"));
        message.setFrom(form);

        // 设置收件人
        InternetAddress sendUserMail = new InternetAddress(sendUser);
        message.setRecipient(Message.RecipientType.TO, sendUserMail);

        // 设置邮件标题
        message.setSubject(title);
        // 设置邮件的内容体
        message.setContent(content, "text/html;charset=UTF-8");
        // 3、发送邮件 邮件发送对象
        Transport.send(message);
    }

    public static void sendEmailYy(String sendUser, String title, String content) throws MessagingException {
        // 0、配置发送邮件的环境属性
        final Properties props = new Properties();
        // 表示SMTP发送邮件，需要进行身份验证
        props.put("mail.smtp.auth", "true");//需要验证
//        props.put("mail.smtp.host", "smtp.yonyou.com");
//        props.put("mail.smtp.host", "mail.yonyou.com");
        props.put("mail.smtp.host", "mail.yonyou.com");
        props.put("mail.user", "cjzfyw@chanpay.com");
        props.put("mail.password", "Aaaa1111");

        // 构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };

        // 1、使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);
        // 2、创建邮件消息 Message对象实例代表一封电子邮件
        MimeMessage message = new MimeMessage(mailSession);
        // 设置发件人
        InternetAddress form = new InternetAddress(props.getProperty("mail.user"));
        message.setFrom(form);

        // 设置收件人
        InternetAddress sendUserMail = new InternetAddress(sendUser);
        message.setRecipient(Message.RecipientType.TO, sendUserMail);

        // 设置邮件标题
        message.setSubject(title);
        // 设置邮件的内容体
        message.setContent(content, "text/html;charset=UTF-8");
        // 3、发送邮件 邮件发送对象
        Transport.send(message);
    }

    /**
     * yyyy-MM-dd HH:mm:ss
     */
    private final static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 返回当前时间
     *
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String getNowDate() {
        LocalDateTime now = LocalDateTime.now();
        final String format = now.format(dateTimeFormatter);
        return format.toString();
    }

    /**
     * 发送普通邮箱
     * @throws MessagingException
     */
    private void sendMimeMail() throws MessagingException {
        // 1、设置连接会话属性
        //也可用Properties props = System.getProperties();
        Properties props = new Properties();
        //存储发送邮件服务器的信息，这里以qq为例
//        props.put("mail.smtp.host", "smtp.qq.com");
        props.put("mail.smtp.host", "mail.yonyou.com");
//        props.put("mail.smtp.host", "10.20.10.126");
        //通过验证方式连接邮件服务器
        // props.put("mail.smtp.auth", "true");
        //根据属性新建一个邮件会话.
        Session session = Session.getInstance(props);
        //如果需要在发送邮件过程中监控mail命令的话，可以在发送前设置debug标志
        session.setDebug(true);

        // 2、创建邮件对象
        //由邮件会话新建一个消息对象
        MimeMessage message = new MimeMessage(session);

        // 3、设置邮件相关信息
        //创建发件人地址对象
        InternetAddress from = new InternetAddress("cjzfyw@chanpay.com");
        //设置发件人 收到邮件后显示的发件人地址是设置的setFrom值 而不是真正的发送邮箱
        message.setFrom(from);
        //创建收件人地址对象
        InternetAddress to = new InternetAddress("1913475244@qq.com");
        //设置收件人,并设置其接收类型为TO
        message.setRecipient(Message.RecipientType.TO, to);
        //设置邮件主题
        message.setSubject("发送文本邮箱");
        //设置信件内容，纯文本邮件
        message.setText("发送普通邮箱");
        //设置发信时间
        message.setSentDate(new Date());

        //4、发送邮件
        //存储邮件信息
        message.saveChanges();
        //创建邮件发送对象，并指定其使用SMTP协议发送邮件
        Transport transport=session.getTransport("smtp");
        // 以smtp方式登录邮箱
        // 在transport.connect中设置的用户名和密码是为了连接邮箱服务器 该用户名不一定是收到邮件的发件人
        // 发件人以message.setFrom中设置的为准
        transport.connect("mail.yonyou.com","cjzfyw@chanpay.com","Aaaa1111");
//        transport.connect("mail.yonyou.com",null,null);
        //发送邮件,也可以使用静态方法Transport.send(message);
        transport.sendMessage(message, message.getAllRecipients());
        //关闭连接
        transport.close();
    }

    /**
     * 发送HTML格式邮件
     */
    private void sendHtmlMail() throws MessagingException {
        // 1、设置连接会话属性
        //也可用Properties props = System.getProperties();
        Properties props = new Properties();
        //存储发送邮件服务器的信息，这里以qq为例
        props.put("mail.smtp.host", "smtp.qq.com");
        //通过验证方式连接邮件服务器
        props.put("mail.smtp.auth", "true");
        //根据属性新建一个邮件会话.
        Session session = Session.getInstance(props);
        //如果需要在发送邮件过程中监控mail命令的话，可以在发送前设置debug标志
        session.setDebug(true);

        // 2、创建邮件对象
        //由邮件会话新建一个消息对象
        MimeMessage message = new MimeMessage(session);

        // 3、设置邮件相关信息
        //创建发件人地址对象
        InternetAddress from = new InternetAddress("1913475244@qq.com");
        //设置发件人 收到邮件后显示的发件人地址是设置的setFrom值 而不是真正的发送邮箱
        message.setFrom(from);
        //创建收件人地址对象
        InternetAddress to = new InternetAddress("1913475244@qq.com");
        //设置收件人,并设置其接收类型为TO
        message.setRecipient(Message.RecipientType.TO, to);
        //设置邮件主题
        message.setSubject("发送Html邮件");
        //邮件内容
        String body="<h4><font color=red>Welcome!</font></h4>";
        //设置HTML格式的邮件正文
        message.setContent(body,"text/html;charset=gb2312");
        //设置发信时间
        message.setSentDate(new Date());

        //4、发送邮件
        //存储邮件信息
        message.saveChanges();
        //创建邮件发送对象，并指定其使用SMTP协议发送邮件
        Transport transport=session.getTransport("smtp");
        // 以smtp方式登录邮箱
        // 在transport.connect中设置的用户名和密码是为了连接邮箱服务器 该用户名不一定是收到邮件的发件人
        // 发件人以message.setFrom中设置的为准
        transport.connect("smtp.qq.com","1913475244@qq.com",authorizationCode);
        //发送邮件,也可以使用静态方法Transport.send(message);
        transport.sendMessage(message, message.getAllRecipients());
        //关闭连接
        transport.close();
    }

    /**
     * 发送带附件的邮件需要用到JAF框架的DataHandler
     */
    private void sendFileMail() throws MessagingException {
        // 1、创建附件内容对象
        //新建一个存放信件内容的BodyPart对象
        BodyPart messageBodyPart = new MimeBodyPart();

        // 2、设置附件内容对象的数据源和DataHandler
        //建立附件数据源,也可以使用URLDataSource(url)
        //DataSource source = new FileDataSource(filename);
        //设置附件的DataHandler
        //messageBodyPart.setDataHandler(new DataHandler(source));
        //设置附件的名称
       // messageBodyPart.setFileName(filename);

        // 3、创建附件对象
        //新建一个MimeMultipart对象用来存放BodyPart对象(事实上可以存放多个)
        Multipart multipart = new MimeMultipart();
        //将附件内容对象加入到MimeMultipart对象中(可以加入多个BodyPart)
        multipart.addBodyPart(messageBodyPart);

        // 4、添加附件
        // 将附件添加到邮件内容中。
        //message.setContent(multipart);
    }

    @Test
    public void test1() {
        String sendUser = "liusiy@yonyou.com";
        String sendUserTo = "1913475244@qq.com";
        String sendUserToCaoJ = "caojiaf@yonyou.com";
        String title = "测试邮箱";
        String content = "发送普通邮箱";
        try {
            EmailUtils.sendEmail(sendUserTo, title, content);
            System.out.println("发送邮箱时间: " + System.currentTimeMillis());
            System.out.println("发送邮箱时间: " + getNowDate());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testText() throws MessagingException {
        // 使用授权码后成功、密码失败
        this.sendMimeMail();
    }
    @Test
    public void testHtml() throws MessagingException {
        // 使用授权码后成功
        this.sendHtmlMail();
    }
    @Test
    public void testYonyou() {
        String sendUserTo = "1913475244@qq.com";
        String title = "YY通知邮箱";
        String content = "测试是否发送成功";
        try {
            EmailUtils.sendEmailYy(sendUserTo, title, content);
            System.out.println("发送邮箱时间: " + System.currentTimeMillis());
            System.out.println("发送邮箱时间: " + getNowDate());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
