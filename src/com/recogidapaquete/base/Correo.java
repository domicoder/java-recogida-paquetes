
package com.recogidapaquete.base;

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
            Properties p = new Properties();
            p.put("mail.smtp.host", "smtp.gmail.com");
            p.setProperty("mail.smtp.starttls.enable", "true");
            p.setProperty("mail.smtp.port", "587");
            p.setProperty("mail.smtp.user", "repaq01@gmail.com"); // aqui el usuarrio con el que se envia el correo
            p.setProperty("mail.smtp.auth", "true");
            Session s = Session.getDefaultInstance(p);
            MimeMessage message = new MimeMessage(s);
            message.setFrom(new InternetAddress("repaq01@gmail.com")); //correo con el con el cual quieres enviar el correo
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));   //Se podrían añadir varios de la misma manera ya que este seria el destino
            message.setSubject("📦 Tienes un Paquete Disponible para Entrega en RePAQ");  // para el asunto del mensaje 
            
            message.setText("Estimado(a)\nTe informamos que tienes un paquete disponible para entrega en tu"
                    + "sucursal de RePAQ.\n\nGracias por Preferirnos.\nRePAQ"); // aqui para enviar el mensaje el cuerpo
            Transport t = s.getTransport("smtp"); // para conectar con el servidor
            t.connect( "repaq01@gmail.com","vloqtdeilslusdip");// para poder obterne contrasena y correo 
            t.sendMessage(message, message.getAllRecipients());// para conectar con el servidor de envio de google
            t.close(); // para cerrar el metodo
            JOptionPane.showMessageDialog(null,"Se ha enviado la notificación al correo.", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
        }catch (MessagingException me) {
            me.printStackTrace();   //Si se produce un error
            JOptionPane.showMessageDialog(null,"Error al enviar el correo.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
 