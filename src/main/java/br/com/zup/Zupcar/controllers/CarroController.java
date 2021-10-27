package br.com.zup.Zupcar.controllers;

import br.com.zup.Zupcar.dtos.CarroDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/carros") // Mapea as requisições para o endpoint nele contido
public class CarroController {
    private List<CarroDTO> concessionaria = new ArrayList<>();

    @GetMapping // é o Request Mapping utilizando o Verbo GET do PROTOCOLO HTTP
    public List<CarroDTO> exibirTodosOsCarros(){
        return concessionaria;
    }

    @PostMapping // é o Request Mapping utilizando o Verbo POST do PROTOCOLO HTTP
    public void cadastrarCarro(@RequestBody CarroDTO carroDTO){
        // Todo Classe DTO são representações de Json seja de Entrada ou Saida.
        concessionaria.add(carroDTO);
    }
}
