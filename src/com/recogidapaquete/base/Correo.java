
package com.recogidapaquete.base;

import com.recogidapaquete.config.ConfigManager;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class Correo implements Observer{
    
    private String email;
    private String estado;
    
    // Load SMTP credentials from external configuration
    private static final ConfigManager config = ConfigManager.getInstance();

    public Correo() {
    }
    
    //Getters
    public String getEmail() {
        return email;
    }
    
    public String getEstado() {
        return estado;
    }

    //Setters
    public void setEmail(String email) {
        this.email = email;
    }

    public void setEstado(Paquete paquete) {
        this.estado = paquete.getEstadoValido();
    }
    
    //Metodo que ejecuta el Observador Correo de su Sujeto RecogerPaquete
    @Override
    public void update() {
        try {
            // Get SMTP configuration from external config file
            String smtpUser = config.getSmtpUser();
            String smtpPassword = config.getSmtpPassword();
            
            Properties p = new Properties();
            p.put("mail.smtp.host", config.getSmtpHost());
            p.setProperty("mail.smtp.starttls.enable", config.getSmtpStartTls());
            p.setProperty("mail.smtp.port", config.getSmtpPort());
            p.setProperty("mail.smtp.user", smtpUser);
            p.setProperty("mail.smtp.auth", config.getSmtpAuth());
            
            Session s = Session.getDefaultInstance(p);
            MimeMessage message = new MimeMessage(s);
            message.setFrom(new InternetAddress(smtpUser)); // correo con el cual se envía
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email)); // destino
            message.setSubject("📦 Tienes un Paquete Disponible para Entrega en RePAQ");
            
            message.setText("Estimado(a)\nTe informamos que tienes un paquete disponible para entrega en tu"
                    + "sucursal de RePAQ.\n\nGracias por Preferirnos.\nRePAQ");
            
            Transport t = s.getTransport("smtp");
            t.connect(smtpUser, smtpPassword); // credenciales desde configuración externa
            t.sendMessage(message, message.getAllRecipients());
            t.close();
            JOptionPane.showMessageDialog(null,"Se ha enviado la notificación al correo.", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
        }catch (MessagingException me) {
            me.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error al enviar el correo.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
 