package com.intercorp.example.client.model.request;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
@Data
@ApiModel(value = "ClientRequest", description = "ClientRequest")
public class ClientRequest {

    @NotEmpty
    @NotBlank
    private String nombre;
    @NotEmpty
    @NotBlank
    private String apellido;
    @NotEmpty
    @NotBlank
    private Integer edad;
    @NotEmpty
    @NotBlank
    private Date fechaNac;
}
