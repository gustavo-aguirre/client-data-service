package com.intercorp.example.client.controller;

import com.intercorp.example.client.model.Client;
import com.intercorp.example.client.model.request.ClientRequest;
import com.intercorp.example.client.model.response.ClientDtoResponse;
import com.intercorp.example.client.model.response.KpiCliente;
import com.intercorp.example.client.service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@Api(value = "REST API Clientes.", tags = "Metodos clientes")
public class ClientController {
    @Autowired
    private ClientService clientService;
    @ApiOperation(value = "Crea un cliente")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping(value = "creaCliente", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> creaCliente(@RequestBody ClientRequest request)
            throws Exception {
        clientService.createClient(request);
        return ResponseEntity.ok().build();
    }
    @ApiOperation(value = "Retorna promedio y Desviación estándar entre las edades de todos los clientes")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Kpi de Cliente ", response = KpiCliente.class),
            @ApiResponse(code = 500, message = "Error procesando la Solicitud", response = Exception.class) })
    @GetMapping(value = "/kpideclientes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KpiCliente> kpideclientes() throws Exception {
        KpiCliente kpi = clientService.kpideclientes();
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(kpi);
    }

    @ApiOperation(value = "Retorna listado de clientes con la fecha probable de muerte")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lista de personas ", response = ClientDtoResponse.class, responseContainer = "List"),
            @ApiResponse(code = 500, message = "Error procesando la Solicitud", response = Exception.class) })
    @GetMapping(value = "/listclientes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClientDtoResponse>> listclientes() throws Exception {
        List<ClientDtoResponse> clients = clientService.getAllClientsWithDeadDate();
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(clients);
    }
}

