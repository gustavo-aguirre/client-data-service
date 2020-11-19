package com.intercorp.example.client.model.response;

import com.intercorp.example.client.model.Client;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ClientDtoResponse extends Client {
    private LocalDate fechaMuerte;


    public ClientDtoResponse(String nombre, String apellido, Integer edad, LocalDate fechaNac, LocalDate fechaMuerte) {
        this.setNombre(nombre);
        this.setEdad(edad);
        this.setApellido(apellido);
        this.setFechaNac(fechaNac);
        this.setFechaMuerte(fechaMuerte);
    }
}
