package services;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailService {

    private static final String FROM_EMAIL = "ton-email@example.com"; // Email de l'expéditeur (email de gestion)
    private static final String FROM_PASSWORD = "ton-mot-de-passe";    // Mot de passe de l'email de gestion
    private static final String SMTP_HOST = "smtp.example.com";         // Hôte SMTP (par exemple, smtp.gmail.com pour Gmail)
    private static final String SMTP_PORT = "587";                      // Port SMTP (587 pour Gmail)

    public static void envoyerEmail(String destinataire, String nouveauMotDePasse) {
        // Configuration des propriétés du serveur SMTP
        Properties properties = new Properties();
        properties.put("mail.smtp.host", SMTP_HOST);
        properties.put("mail.smtp.port", SMTP_PORT);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true"); // Activer TLS

        // Authentification avec l'email de gestion
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FROM_EMAIL, FROM_PASSWORD);
            }
        });

        try {
            // Créer un message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(FROM_EMAIL));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(destinataire));
            message.setSubject("Réinitialisation de votre mot de passe");

            // Le contenu de l'email
            String contenu = "Bonjour,\n\nVoici votre nouveau mot de passe : " + nouveauMotDePasse + "\n\nMerci.";
            message.setText(contenu);

            // Envoi du message
            Transport.send(message);
            System.out.println("E-mail envoyé avec succès à " + destinataire);
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de l'envoi de l'email.");
        }
    }
}
