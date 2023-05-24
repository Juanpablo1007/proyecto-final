package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.dto.EmailGetDTO;

public interface EmailServicio {
    boolean enviarEmail(EmailGetDTO emailGetDTO) throws Exception;
}
