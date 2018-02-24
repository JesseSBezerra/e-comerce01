package br.com.ecomerce.infra.email;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.com.ecomerce.infra.properties.PropertiesUtil;

public class EmailUtil
{
      
      public static void mail(String remetente,String destinatarios,String assunto,String texto){
    	  Properties props = new Properties();
          props.put("mail.smtp.host", "smtp.gmail.com");
          props.put("mail.smtp.socketFactory.port", "465");
          props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
          props.put("mail.smtp.auth", "true");
          props.put("mail.smtp.port", "465");

          Session session = Session.getDefaultInstance(props,
                      new javax.mail.Authenticator() {
                           protected PasswordAuthentication getPasswordAuthentication() 
                           {
                                 return new PasswordAuthentication(PropertiesUtil.getProp("email"), PropertiesUtil.getProp("senha_email"));
                           }
                      });

          session.setDebug(true);

          try {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(remetente)); 

                Address[] toUser = InternetAddress 
                           .parse(destinatarios);  

                message.setRecipients(Message.RecipientType.TO, toUser);
                message.setSubject(assunto);
                message.setText(texto);
                
                Transport.send(message);


           } catch (MessagingException e) {
                throw new RuntimeException(e);
          }
      }
}

