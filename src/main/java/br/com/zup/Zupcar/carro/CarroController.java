package br.com.zup.Zupcar.carro;

import br.com.zup.Zupcar.carro.dtos.CarroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carros") // Mapea as requisições para o endpoint nele contido
public class CarroController {

    @Autowired
    private CarroService carroService;

    @GetMapping // é o Request Mapping utilizando o Verbo GET do PROTOCOLO HTTP
    public List<CarroDTO> exibirTodosOsCarros(){
        return carroService.pegarTodosOsCarros();
    }

    @PostMapping // é o Request Mapping utilizando o Verbo POST do PROTOCOLO HTTP
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarCarro(@RequestBody CarroDTO carroDTO){
        // Toda Classe DTO são representações de Json seja de Entrada ou Saida.
        carroService.salvarCarro(carroDTO);
    }

    @GetMapping("/{nomeDoCarro}")
    public CarroDTO exibirCarro(@PathVariable String nomeDoCarro){
        return carroService.buscarCarro(nomeDoCarro);
    }

    @PutMapping("/{nomeDoCarro}")
    public CarroDTO atualizarCarro(@PathVariable String nomeDoCarro, @RequestBody CarroDTO carroDTO ) {
        return carroService.atualizarCarro(nomeDoCarro, carroDTO);
    }
}
