package co.edu.uniquindio.proyecto.controladores;
import co.edu.uniquindio.proyecto.dto.EmailGetDTO;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;
import java.util.Properties;

@RestController
@AllArgsConstructor
@RequestMapping( value = "api/email")
public class EmailController {/**
    @PostMapping()
    public ResponseEntity<String> enviarEmail(@Valid @RequestBody EmailGetDTO emailGetDTO) {
        try {
            enviarCorreo(emailGetDTO);
            return ResponseEntity.ok("Correo electrónico enviado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al enviar el correo electrónico: " + e.getMessage());
        }
    }

    private void enviarCorreo(EmailGetDTO emailGetDTO) throws MessagingException {
        // Configuración del servidor de correo
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com"); // Reemplazar con el host del servidor de correo saliente
        props.put("mail.smtp.port", "587"); // Reemplazar con el puerto del servidor de correo saliente

        // Credenciales de autenticación
        String username = "juannaruto51@gmail.com"; // Reemplazar con la dirección de correo electrónico
        String password = "Juanpablo1"; // Reemplazar con la contraseña

        // Creación de la sesión de correo
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        // Creación del mensaje de correo
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(emailGetDTO.getDestinatario()));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailGetDTO.getDestinatario()));
        message.setSubject(emailGetDTO.getAsunto());
        message.setText(emailGetDTO.getCuerpo());

        // Envío del correo electrónico
        Transport.send(message);
    }**/
}
