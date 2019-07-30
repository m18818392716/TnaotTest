package com.tnaot.utils.AppiumUtils;

import de.idyl.winzipaes.AesZipFileDecrypter;
import de.idyl.winzipaes.AesZipFileEncrypter;
import de.idyl.winzipaes.impl.AESDecrypterBC;
import de.idyl.winzipaes.impl.AESEncrypterBC;
import de.idyl.winzipaes.impl.ExtZipEntry;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.zip.DataFormatException;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;

public class SendEmail {

//    static String HOST = "smtp.163.com"; // smtp服务器
//    static String FROM = "m18818392716@163.com"; // 发件人地址
//    static String USER = "m18818392716@163.com"; // 用户名
//    static String PWD = "cq183159"; // 163的授权码
//    static String SUBJECT = "手表服务抛异常了"; // 邮件标题
//    static String[] TOS = new String[]{"m18818392716@163.com"};



    static String HOST = "smtp.qq.com"; // smtp服务器-端口465或587 SMTP服务器需要身份验证
//    static String HOST = "pop.qq.com"; // POP3服务器-端口995
    static String FROM = "2240607006@qq.com"; // 发件人地址
    static String USER = "2240607006@qq.com"; // 用户名
    static String PWD = "uslrjkepjnkldjfi"; // 163的授权码
    static String SUBJECT = "Allure Report 自动化测试报告2019-07-30"; // 邮件标题
    static String[] TOS = new String[]{"394941528@qq.com"};//uslrjkepjnkldjfi


    /**
     * 发送邮件
     * @param host
     * @param user
     * @param pwd
     */
    public static void send(String context, String srcPath) {
        Properties props = new Properties();
        props.put("mail.smtp.host", HOST);//设置发送邮件的邮件服务器的属性（这里使用网易的smtp服务器）
        props.put("mail.smtp.auth", "true");  //需要经过授权，也就是有户名和密码的校验，这样才能通过验证（一定要有这一条）
        Session session = Session.getDefaultInstance(props);//用props对象构建一个session
        session.setDebug(true);
        MimeMessage message = new MimeMessage(session);//用session为参数定义消息对象
        try {
            message.setFrom(new InternetAddress(FROM));// 加载发件人地址
            InternetAddress[] sendTo = new InternetAddress[TOS.length]; // 加载收件人地址
            for (int i = 0; i < TOS.length; i++) {
                sendTo[i] = new InternetAddress(TOS[i]);
            }
            message.addRecipients(Message.RecipientType.TO,sendTo);
            message.addRecipients(MimeMessage.RecipientType.CC, InternetAddress.parse(FROM));//设置在发送给收信人之前给自己（发送方）抄送一份，不然会被当成垃圾邮件，报554错
            message.setSubject(SUBJECT);//加载标题
            Multipart multipart = new MimeMultipart();//向multipart对象中添加邮件的各个部分内容，包括文本内容和附件

            MimeBodyPart attach1 = new MimeBodyPart();//创建附件1
            MimeBodyPart attach2 = new MimeBodyPart();//创建附件2
            MimeBodyPart attach3 = new MimeBodyPart();//创建附件3
            BodyPart contentPart = new MimeBodyPart();//设置邮件的文本内容
            contentPart.setText(context);

            multipart.addBodyPart(attach1);
            multipart.addBodyPart(attach3);
            multipart.addBodyPart(contentPart);


            //附件一的操作
            //方式1：通过右上角绿色的运行按钮执行XML文件
            //FileDataSource fds1 = new FileDataSource(new File("D:\\software\\idea-workspace\\test-output\\Extent.html"));//构造附件一的数据源
            //方式2：通过java调用cmd命令模式执行maven命令
            FileDataSource fds1 = new FileDataSource(new File("D:\\software\\idea-workspace\\target\\surefire-reports\\Extent.html"));//构造附件一的数据源
            DataHandler dh1 = new DataHandler(fds1);//数据处理
            attach1.setDataHandler(dh1);//设置附件一的数据源
            attach1.setFileName("AutomationReport.html");//设置附件一的文件名

            //附件二的操作与附件一类似，这里就不一一注释了
            FileDataSource fds2 = new FileDataSource(new File("D:\\software\\idea-workspace\\src\\res\\frontPage\\UILibrary.xlsx"));
            DataHandler dh2 = new DataHandler(fds2);
            attach2.setDataHandler(dh2);
            attach2.setFileName(MimeUtility.encodeText("UILibrary.xlsx"));//设置文件名时，如果有中文，可以通过MimeUtility类中的encodeText方法进行编码，避免乱码


            //附件三-》对文件进行压缩-》添加到压缩文件（压缩后的命名）--方法1
//            String srcFile= "D:/software/idea-workspace/test-output/report.html";
//            String desFile= "D:/software/idea-workspace/test.zip";
//            zipFile(srcFile, desFile);

            //附件三-》对文件夹下面的所有文件进行压缩-》添加到压缩文件（压缩后的命名）--方法2
            //String srcPath = "D:/software/idea-workspace/test-output";
            String desPath = "D:/software/idea-workspace/report.zip";
            FileOutputStream fos1 = new FileOutputStream(new File(desPath));
            ZipUtils.toZip(srcPath, fos1, true);

            FileDataSource fds3 = new FileDataSource(new File(desPath));//构造附件一的数据源
            DataHandler dh3 = new DataHandler(fds3);//数据处理
            attach3.setDataHandler(dh3);//设置附件一的数据源
            attach3.setFileName("AutomationReport.zip");//设置附件一的文件名


            message.setContent(multipart);//将multipart对象放到message中
            message.saveChanges(); //保存邮件
            Transport transport = session.getTransport("smtp");//发送邮件
            transport.connect(HOST, USER, PWD);//连接服务器的邮箱
            transport.sendMessage(message, message.getAllRecipients());//把邮件发送出去
            transport.close();//关闭连接
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 压缩单个文件并加密
     * @param srcFile      待压缩的文件
     * @param desFile  生成的目标文件
     * @param passWord     压缩文件加密密码
     * @throws IOException
     */
    public static void zipFile(String srcFile,String desFile) throws IOException {
//        AesZipFileEncrypter.zipAndEncrypt(new File(srcFile),new File(desFile), passWord, new AESEncrypterBC());
        AesZipFileEncrypter.zip(new File(srcFile), new File(desFile));
    }


    /**
     * 给指定的压缩文件进行加密
     * @param srcZipFile      待加密的压缩文件
     * @param desFile         加密后的目标压缩文件
     * @param passWord        压缩文件加密密码
     * @throws IOException
     */
    public static void encryptZipFile(String srcZipFile,String desFile,String passWord) throws IOException{
        AesZipFileEncrypter.zipAndEncryptAll(new File(srcZipFile), new File(desFile), passWord, new AESEncrypterBC());
    }

    /**
     * 解密抽取压缩文件中的某个文件
     * @param srcZipFile    加密的压缩文件
     * @param extractFileName  抽取压缩文件中的某个文件的名称
     * @param desFile          解压后抽取后生成的目标文件
     * @param passWord         解压密码
     * @throws IOException
     * @throws DataFormatException
     */
    public static void  decrypterZipFile(String srcZipFile,String extractFileName,String desFile,String passWord)throws IOException, DataFormatException {
        AesZipFileDecrypter zipFile = new AesZipFileDecrypter( new File(srcZipFile),new AESDecrypterBC());
        ExtZipEntry entry = zipFile.getEntry(extractFileName);
        zipFile.extractEntry(entry, new File(desFile),passWord);
    }


//    public static void main(String[] args) {
//
//        try {
//
//            String startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date());
//            System.out.println("开始发送邮件,开始时间："+startTime);
//
//            send("mongo连接池出异常了！！！！！");
//            System.out.println("发送邮件成功！");
//
//            String endTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date());
//            System.out.println("发送邮件成功！结束时间："+endTime);
//        } catch (Exception e) {
//            System.out.println("发送邮件失败！");
//            e.printStackTrace();
//        }
//    }


    /**
     * 发送邮件-压缩test-output文件夹-通过QQ邮箱或者163邮箱发给对应的人
     */
    public static void send(String srcPath) {

        try {

            String startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date());
            System.out.println("开始发送邮件,开始时间："+startTime);

            send("mongo连接池出异常了！！！！！", srcPath);
            System.out.println("发送邮件成功！");

            String endTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date());
            System.out.println("发送邮件成功！结束时间："+endTime);
        } catch (Exception e) {
            System.out.println("发送邮件失败！");
            e.printStackTrace();
        }
    }
}
