package com.intercorp.example.client.service.imp;

import com.intercorp.example.client.business.ClientBuilder;
import com.intercorp.example.client.dao.ClientRepository;
import com.intercorp.example.client.model.Client;
import com.intercorp.example.client.model.request.ClientRequest;
import com.intercorp.example.client.model.response.ClientDtoResponse;
import com.intercorp.example.client.model.response.KpiCliente;
import com.intercorp.example.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class ClientServiceImp implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void  createClient(ClientRequest clientRequest) {

        clientRepository.save(ClientBuilder.build(clientRequest));
    }

    @Override
    public List<ClientDtoResponse> getAllClientsWithDeadDate() {

        final LocalDate today = LocalDate.now();
        final Random rand = new Random();

        return clientRepository
                .findAll()
                .stream()
                .map(p -> new ClientDtoResponse(p.getNombre(),
                        p.getApellido(), p.getEdad(), p.getFechaNac(),
                        today.plusDays(rand.nextInt(3650))))
                .collect(Collectors.toList());

    }
    @Override
    public KpiCliente kpideclientes() throws Exception {
        List<Client> clients = clientRepository.findAll();
        double mean = getMean(clients);
        double standardDeviation = getStandardDeviation(clients, mean);
        return KpiCliente.builder().promedio(mean).desviacion(standardDeviation).build();
    }

    private double getMean(List<Client> clients){
        return clients.stream().mapToInt(c -> c.getEdad()).average().orElse(0);
    }
    private double getVariance(List<Client> clients, double mean){
        double variance = clients.stream()
                .map(i -> i.getEdad() - mean)
                .map(i -> i*i)
                .mapToDouble(i -> i).average().getAsDouble();
        return variance;
    }
    private double getStandardDeviation(List<Client> clients, double mean) throws Exception {
            return  Math.sqrt(getVariance(clients,mean));
    }


}
