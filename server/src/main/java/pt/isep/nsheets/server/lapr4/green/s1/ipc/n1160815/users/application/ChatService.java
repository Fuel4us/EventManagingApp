package pt.isep.nsheets.server.lapr4.green.s1.ipc.n1160815.users.application;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.util.Properties;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.domain.User;
import pt.isep.nsheets.server.lapr4.green.s1.core.n1160557.users.persistence.UserRepository;
import pt.isep.nsheets.server.lapr4.green.s1.ipc.n1160815.users.domain.Message;
import pt.isep.nsheets.server.lapr4.white.s1.core.n4567890.workbooks.persistence.PersistenceContext;
import pt.isep.nsheets.shared.services.MessagesDTO;
import pt.isep.nsheets.server.lapr4.green.s1.ipc.n1160815.users.persistence.MessagesRepository;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
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

    public void referenceHandler(String message, String sender) {
        final UserRepository userRepo = PersistenceContext.repositories().users();

        String[] word = message.split(" ");

        for (int i = 0; i < word.length; i++) {
            if (word[i].startsWith("@")) {
                String username = word[i].substring(1);
                User foundUser = userRepo.findByUsername(username);
                if (foundUser.isLoggedIn()) {
                    //send notification

                } else {
                    String userEmail = foundUser.getEmail();
                    try {
                        //send email
                        sendEmail(userEmail, sender, message);
                    } catch (MessagingException ex) {
                        Logger.getLogger(ChatService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    public void sendEmail(String receiverEmail, String sender, String message) throws AddressException, MessagingException {

        Properties mailServerProperties;
        Session getMailSession;
        MimeMessage generateMailMessage;

        // Step1
        System.out.println("\n 1st ===> setup Mail Server Properties..");
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");
        System.out.println("Mail Server Properties have been setup successfully..");

        // Step2
        System.out.println("\n\n 2nd ===> get Mail Session..");
        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        generateMailMessage = new MimeMessage(getMailSession);
        generateMailMessage.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress("josueluislapa@gmail.com"));
        generateMailMessage.addRecipient(javax.mail.Message.RecipientType.CC, new InternetAddress("josueluislapa@gmail.com"));
        generateMailMessage.setSubject("Greetings from NSheets..");
        String emailBody = "The user " + sender + " as mentioned you in a chat message.<br><br>"+ "Message: " + message + "<br><br><br>Best Regards, <br>NSheets";
        generateMailMessage.setContent(emailBody, "text/html");
        System.out.println("Mail Session has been created successfully..");

        // Step3
        System.out.println("\n\n 3rd ===> Get Session and Send mail");
        Transport transport = getMailSession.getTransport("smtp");

        // Enter your correct gmail UserID and Password
        // if you have 2FA enabled then provide App Specific Password
        transport.connect("smtp.gmail.com", "nsheetswebapp@gmail.com", "webversionofcleansheets");
        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
        transport.close();
    }
}
