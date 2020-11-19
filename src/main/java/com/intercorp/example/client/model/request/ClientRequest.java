package com.intercorp.example.client.model.request;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@ApiModel(value = "ClientRequest", description = "ClientRequest")
public class ClientRequest {

    @NotEmpty
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    @NotEmpty
    @NotBlank(message = "El apellido es obligatorio")
    private String apellido;
    @NotEmpty
    @NotBlank
    @Min(value = 1, message = "La edad no puede ser menor a 1")
    @Max(value = 100, message = "La edad no puede ser mayor a 100")
    private Integer edad;
    @NotEmpty
    @NotBlank
    @Past
    private LocalDate fechaNac;
}
