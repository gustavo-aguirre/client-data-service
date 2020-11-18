package com.intercorp.example.client.service;

import com.intercorp.example.client.model.Client;
import com.intercorp.example.client.model.request.ClientRequest;
import com.intercorp.example.client.model.response.KpiCliente;

import java.util.List;


public interface ClientService {

    void createClient(ClientRequest clientRequest)throws Exception;
    List<Client> findAllClient() throws Exception;
    KpiCliente kpideclientes() throws Exception;

}
