package sendfacture;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class sendFacture {

    public sendFacture(windowMain w,
            String to_email,
            String subject,
            String text,
            String facture_name,
            String facture_code,
            String from_email,
            String password) {

        if (subject.length() <= 0 || subject.equals("Asunto")) {
            subject = (facture_name + facture_code).toUpperCase();
        }

        if (text.length() <= 0 || text.equals("Escriba un mensaje para el destinatario")) {
            text = "";
        }

        MimeMessage msg = new MimeMessage(getSessionMailJava()); // Create object msg

        try {
            w.setEnabled(false);
            // MESSAGE PROPERTIES
            msg.setFrom(new InternetAddress(from_email));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to_email));
            msg.setSubject(subject);
            msg.setText(text);

            // FACTURE SETTINGS
            String filename = w.RUTE_FACTURES + (facture_name + facture_code).toUpperCase() + ".pdf";
            DataSource source = new FileDataSource(filename);
            msg.setDataHandler(new DataHandler(source));
            msg.setFileName((facture_name + facture_code).toUpperCase() + ".pdf");

            // TRANSPORT PROPERTIES
            Transport trans = getSessionMailJava().getTransport("smtp");
            trans.connect(from_email, password);
            trans.sendMessage(msg, msg.getRecipients(Message.RecipientType.TO));
            
            trans.close();
            w.setEnabled(true);
            w.setShowAlert("Facture sended.", 1);
            JOptionPane.showMessageDialog(null, "Factura generada y enviada de forma exitosa.", "", JOptionPane.INFORMATION_MESSAGE);
        } catch (AddressException ex) {
            Logger.getLogger(windowMain.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "La factura no se ha podido enviar porque no existe ese correo.", "", JOptionPane.ERROR_MESSAGE);
            w.setEnabled(true);
        } catch (MessagingException ex) {
            Logger.getLogger(windowMain.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Se ha producido un error. La factura no se ha podido enviar.", "", JOptionPane.ERROR_MESSAGE);
            w.setEnabled(true);
        }
    }

    public Session getSessionMailJava() {
        // API-SESSION PROPERTIES
        Properties propiedad = new Properties();
        propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
        propiedad.setProperty("mail.smtp.starttls.enable", "true");
        propiedad.setProperty("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(propiedad);
        return session;
    }

}
