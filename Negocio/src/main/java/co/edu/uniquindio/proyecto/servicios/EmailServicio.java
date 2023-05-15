package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.dto.EmailDto;

public interface EmailServicio {
    boolean enviarEmail(EmailDto emailDto) throws Exception;
}
