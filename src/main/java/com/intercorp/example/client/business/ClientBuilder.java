package com.intercorp.example.client.business;

import com.intercorp.example.client.model.Client;
import com.intercorp.example.client.model.request.ClientRequest;

public class ClientBuilder {

    public static Client build(ClientRequest clientRequest){
        return Client.builder()
                .nombre(clientRequest.getNombre())
                .apellido(clientRequest.getApellido())
                .edad(clientRequest.getEdad())
                .fechaNac(clientRequest.getFechaNac())
                .build();
    }
}
