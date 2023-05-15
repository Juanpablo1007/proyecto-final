package co.edu.uniquindio.proyecto.servicios;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import co.edu.uniquindio.proyecto.dto.EmailDto;

import javax.mail.internet.MimeMessage;

@Service
public class PasswordResetRequestImple implements EmailServicio{
   @Autowired

    private JavaMailSender javaMailSender;

    @Override
    public boolean enviarEmail(EmailDto emailDTO) throws Exception {
        MimeMessage mensaje = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mensaje);

        try {
            helper.setSubject(emailDTO.getAsunto());
            helper.setText(emailDTO.getCuerpo(), true);
            helper.setTo(emailDTO.getDestinatario());
            helper.setFrom("no-reply@unimarket.com");

            javaMailSender.send(mensaje);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }
}
