package com.intercorp.example.client.model.response;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "KpiCliente", description = "Promedio y Desviacion")
public class KpiCliente {
   private double promedio;
    private double desviacion;
}
