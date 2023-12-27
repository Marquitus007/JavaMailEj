/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javamailej;
//Importamos los ficheros necesario
import java.io.*;
import java.security.InvalidParameterException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author m.santos.2022
 */
public class Mail implements Serializable{
    //Atributos para los correos, la contraseña,el asunto, el contenido del mensaje
    private static String emailFrom;
    private  static String passwordFrom;
    
    //Properties para luego guardar los elementos que java va a localizar
    /*La clase Session define una sesión de correo básica. Es a través de esta de sesión de la que todas las demás funcionan. 
    El objeto Session se aprovecha de un objeto java.util.Properties
    para obtener información como el servidor de correo, el nombre de usuario, la password, y otra información que puede compartirse a lo largo de toda la aplicación.*/
    private Properties properties;
    private Session sesion;
    /*Esta clase representa un mensaje de correo electrónico de estilo MIME. implementa la clase abstracta Message y la MimePart interfaz.
    Los clientes que deseen crear nuevos mensajes de estilo MIME crearán instancias un objeto MimeMessage vacío y luego rellénelo con el contenido apropiado atributos y contenido.*/
    private MimeMessage correo;
    
    //Constructor de la clase
    public Mail(){
        this.properties=new Properties();
        //Creamos una sesion por defecto
        sesion= Session.getDefaultInstance(properties);        
    }
    
    public void setCorreoFrom(String correo){
        emailFrom=correo;
    }
    public void setContraseña(String contraseña){
        passwordFrom=contraseña;
    }
    
    //metodo para crear el correo
    public void crearEmail(String email,String asunto, String contenido){
        //Añadimos a properties los protocolos de transferencia que necesita java para enviar un correo simple
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.port", "587");
        properties.setProperty("mail.smtp.user", emailFrom);
        properties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.setProperty("mail.smtp.auth", "true");
        
        
        
        
        try {
            correo=new MimeMessage(sesion);
            //Le asignamos quien va a ser el destinatario
            correo.setFrom(new InternetAddress(emailFrom));
            //Establecemos el remitente
            correo.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
            //Ponemos el asunto del correo
            correo.setSubject(asunto);
            //Ponemos el contenido
            correo.setText(contenido);
            
            //capturamos las excepciones
        } catch (MessagingException ex) {
            Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }    
    
    
    //Metodo para enviar el correo
    public void enviarMail(){
        
        
        try {
            //Clase que modela un mensaje de transporte 
            //Seleccionamos el protocol de transporte
            Transport t = sesion.getTransport("smtp");
            //Nos conectamos al correo con la contraseña
            t.connect(emailFrom,passwordFrom);
            //Enviamos el mensaje
            t.sendMessage(correo, correo.getRecipients(Message.RecipientType.TO));
            //Ceramos la transferencia
            t.close();
             //capturamos las excepciones
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("El correo ha sido enviado");
        }

    
}
