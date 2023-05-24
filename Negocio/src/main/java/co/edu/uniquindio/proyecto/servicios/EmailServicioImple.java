package co.edu.uniquindio.proyecto.servicios;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import co.edu.uniquindio.proyecto.dto.EmailGetDTO;

import javax.mail.internet.MimeMessage;

@Service
public class EmailServicioImple implements EmailServicio{
   @Autowired

    private JavaMailSender javaMailSender;

    @Override
    public boolean enviarEmail(EmailGetDTO emailGetDTO) throws Exception {
        MimeMessage mensaje = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mensaje);

        try {
            helper.setSubject(emailGetDTO.getAsunto());
            helper.setText(emailGetDTO.getCuerpo(), true);
            helper.setTo(emailGetDTO.getDestinatario());
            helper.setFrom("no-reply@unimarket.com");

            javaMailSender.send(mensaje);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }
}
