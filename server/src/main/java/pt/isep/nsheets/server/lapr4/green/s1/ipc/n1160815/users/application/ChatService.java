package pt.isep.nsheets.server.lapr4.green.s1.ipc.n1160815.users.application;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.domain.User;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.persistence.UserRepository;
import pt.isep.nsheets.server.lapr4.green.s1.ipc.n1160815.users.domain.Message;
import pt.isep.nsheets.server.lapr4.green.s1.ipc.n1160815.users.domain.Notification;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.shared.services.MessagesDTO;
import pt.isep.nsheets.server.lapr4.green.s1.ipc.n1160815.users.persistence.MessagesRepository;
import pt.isep.nsheets.server.lapr4.green.s1.ipc.n1160815.users.persistence.NotificationRepository;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ChatService {

    public Message addMessage(MessagesDTO mDTO) throws DataConcurrencyException, DataIntegrityViolationException {
        final MessagesRepository messageRepository = PersistenceContext.repositories().messages();

        referenceHandler(mDTO.getText(), mDTO.getUser());

        Message m = Message.fromDTO(mDTO);
        messageRepository.save(m);

        return m;
    }

    public Iterable<Message> allMessages() {
        final MessagesRepository messageRepository = PersistenceContext.repositories().messages();
        return messageRepository.findAll();
    }

    public Iterable<Notification> allNotificationsFromUser(String username) {
        final NotificationRepository notificationRepository = PersistenceContext.repositories().notifications();
        Iterable<Notification> notifications = notificationRepository.findAllFromUser(username);
        notificationRepository.removeNotificationsFromUser(username);
        return notifications;
    }

    public void referenceHandler(String message, String sender) {
        final UserRepository userRepo = PersistenceContext.repositories().users();
        final NotificationRepository notificationRepo = PersistenceContext.repositories().notifications();

        String[] word = message.split(" ");

        for (int i = 0; i < word.length; i++) {
            if (word[i].startsWith("@")) {
                String receiver = word[i].substring(1);
                User receiverUser = userRepo.findByUsername(receiver);
                if (receiverUser.isLoggedIn()) {
                    try {
                        //send notification
                        notificationRepo.save(new Notification(receiverUser.getNickname(), sender, message));
                    } catch (DataConcurrencyException ex) {
                        Logger.getLogger(ChatService.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (DataIntegrityViolationException ex) {
                        Logger.getLogger(ChatService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    String receiverUserEmail = receiverUser.getEmail();
                    try {
                        //send email
                        sendEmail(receiverUserEmail, sender, message);
                    } catch (MessagingException ex) {
                        Logger.getLogger(ChatService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    public void sendEmail(String receiverEmail, String sender, String message) throws AddressException, MessagingException {

//        Properties mailServerProperties;
//        Session getMailSession;
//        MimeMessage generateMailMessage;
//
//        // Step1
//        System.out.println("\n 1st ===> setup Mail Server Properties..");
//        mailServerProperties = System.getProperties();
//        mailServerProperties.put("mail.smtp.port", "587");
//        mailServerProperties.put("mail.smtp.auth", "true");
//        mailServerProperties.put("mail.smtp.starttls.enable", "true");
//        System.out.println("Mail Server Properties have been setup successfully..");
//
//        // Step2
//        System.out.println("\n\n 2nd ===> get Mail Session..");
//        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
//        generateMailMessage = new MimeMessage(getMailSession);
//        generateMailMessage.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress("josueluislapa@gmail.com"));
//        generateMailMessage.addRecipient(javax.mail.Message.RecipientType.CC, new InternetAddress("josueluislapa@gmail.com"));
//        generateMailMessage.setSubject("Greetings from NSheets..");
//        String emailBody = "The user " + sender + " as mentioned you in a chat message.<br><br>" + "Message: " + message + "<br><br><br>Best Regards, <br>NSheets";
//        generateMailMessage.setContent(emailBody, "text/html");
//        System.out.println("Mail Session has been created successfully..");
//
//        // Step3
//        System.out.println("\n\n 3rd ===> Get Session and Send mail");
//        Transport transport = getMailSession.getTransport("smtp");
//
//        // Enter your correct gmail UserID and Password
//        // if you have 2FA enabled then provide App Specific Password
//        transport.connect("smtp.gmail.com", "nsheetswebapp@gmail.com", "webversionofcleansheets");
//        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
//        transport.close();
//#################################################################################################################//
        try {
            final String fromEmail = "nsheetswebapp@gmail.com"; //requires valid gmail id
            final String password = "webversionofcleansheets"; // correct password for gmail id
            final String toEmail = receiverEmail; // can be any email id 

            System.out.println("TLSEmail Start");
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
            props.put("mail.smtp.port", "587"); //TLS Port
            props.put("mail.smtp.auth", "true"); //enable authentication
            props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

            //create Authenticator object to pass in Session.getInstance argument
            Authenticator auth = new Authenticator() {
                //override the getPasswordAuthentication method
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            };
            Session session = Session.getInstance(props, auth);

            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(fromEmail));
            mimeMessage.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(toEmail));

            System.out.println("Mail Check 2");

            mimeMessage.setSubject("NSheets Notification");
            mimeMessage.setText("Greetings from NSheets\n\n\nThe user " + sender + " as mentioned you in a chat message\n\n" + "Message: " + message + "\n\n\nBest Regards, \n\nNSheets");

            System.out.println("Mail Check 3");

            Transport.send(mimeMessage);
            System.out.println("Mail Sent");
        } catch (Exception ex) {
            System.out.println("Mail fail");
            System.out.println(ex);
        }
    }
}
