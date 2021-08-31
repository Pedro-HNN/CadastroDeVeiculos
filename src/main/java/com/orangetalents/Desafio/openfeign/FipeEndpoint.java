package com.orangetalents.Desafio.openfeign;


import com.orangetalents.Desafio.dto.VeiculoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name= "FipeEndpoint",url = "https://parallelum.com.br/fipe/api/v1")
public interface FipeEndpoint {

    @GetMapping(value="/{tipo}/marcas/{marca}/modelos/{modelo}/anos/{ano}", produces = MediaType.APPLICATION_JSON_VALUE)
    VeiculoDTO Get(@PathVariable(value = "tipo") String tipo, @PathVariable(value = "marca") String marca, @PathVariable(value = "modelo")
            String modelo, @PathVariable(value = "ano") String ano);
}
