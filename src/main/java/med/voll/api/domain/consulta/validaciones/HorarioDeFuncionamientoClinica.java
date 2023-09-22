package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class HorarioDeFuncionamientoClinica implements ValidadorDeConsultas {
    public void validar(DatosAgendarConsulta datos) {

        var domingo = DayOfWeek.SUNDAY.equals(datos.fecha().getDayOfWeek());

        var antesDeAperura = datos.fecha().getHour() < 7;
        var despuesDeCierre = datos.fecha().getHour() > 19;

        if (domingo || antesDeAperura || despuesDeCierre) {
            throw new ValidationException("El horario de atención de la clinica es de lunes a sábado de 7 a 19hs");
        }

    }
}
