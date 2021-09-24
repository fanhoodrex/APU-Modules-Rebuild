package Classes;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailHandler {
    public static void sendMail(String Receipents,String Subject,String Content,String Attachment) throws AddressException, MessagingException{
        String myEmail = "class.study2019@gmail.com";
        String password = "cl@sstudy2018%@";
        String opponentEmail = Receipents;
        Properties pro = new Properties();
        pro.put("mail.smtp.host", "smtp.gmail.com");
        pro.put("mail.smtp.starttls.enable", "true");
        pro.put("mail.smtp.auth", "true");
        pro.put("mail.smtp.port", "587");
        Session ss = Session.getInstance(pro, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myEmail, password);
            }
        });
        Message msg = new MimeMessage(ss);
        msg.setFrom(new InternetAddress(myEmail));
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(opponentEmail));
        msg.setSubject(Subject);
        //Transport trans = ss.getTransport("smtp");
        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText(Content);
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        messageBodyPart = new MimeBodyPart();
        String filename = Attachment;
        DataSource source = new FileDataSource("DATA/Reports/" + filename);
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName(filename);
        multipart.addBodyPart(messageBodyPart);
        msg.setContent(multipart);
        Transport.send(msg);
    }
    public static void sendMail(String Receipents,String Subject,String Content) throws AddressException, MessagingException{
        String myEmail = "class.study2019@gmail.com";
        String password = "cl@sstudy2018%@";
        String opponentEmail = Receipents;
        Properties pro = new Properties();
        pro.put("mail.smtp.host", "smtp.gmail.com");
        pro.put("mail.smtp.starttls.enable", "true");
        pro.put("mail.smtp.auth", "true");
        pro.put("mail.smtp.port", "587");
        Session ss = Session.getInstance(pro, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myEmail, password);
            }
        });
        Message msg = new MimeMessage(ss);
        msg.setFrom(new InternetAddress(myEmail));
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(opponentEmail));
        msg.setSubject(Subject);
        Transport trans = ss.getTransport("smtp");
        msg.setText(Content);
        Transport.send(msg);
    }
}
