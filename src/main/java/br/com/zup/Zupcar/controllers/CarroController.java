package br.com.zup.Zupcar.controllers;

import br.com.zup.Zupcar.dtos.CarroDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carros") // Mapea as requisições para o endpoint nele contido
public class CarroController {
    private List<CarroDTO> concessionaria = new ArrayList<>();

    @GetMapping // é o Request Mapping utilizando o Verbo GET do PROTOCOLO HTTP
    public List<CarroDTO> exibirTodosOsCarros(){
        return concessionaria;
    }

    @PostMapping // é o Request Mapping utilizando o Verbo POST do PROTOCOLO HTTP
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarCarro(@RequestBody CarroDTO carroDTO){
        // Todo Classe DTO são representações de Json seja de Entrada ou Saida.
        concessionaria.add(carroDTO);
    }

    @GetMapping("/{nomeDoCarro}")
    public CarroDTO exibirCarro(@PathVariable String nomeDoCarro){
        //forma mais elegante
        Optional<CarroDTO> optionalCarroDTO = concessionaria.stream()
                .filter(carro -> carro.getModelo().equalsIgnoreCase(nomeDoCarro)).findFirst();

        if(optionalCarroDTO.isEmpty() /* Está vazio? A resposta pode ser True ou False */){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não encontrei");
        }

        return optionalCarroDTO.get();
        /*
        Forma menos elegante
        for(CarroDTO objeto : concessionaria){
            if(objeto.getModelo().equals(nomeDoCarro)){
                return objeto;
            }
        }

         throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não encontrei");
        */
    }

    @PutMapping("/{nomeDoCarro}")
    public CarroDTO atualizarCarro(@PathVariable String nomeDoCarro, @RequestBody CarroDTO carroDTO ){
        for(CarroDTO objetoDaLista : concessionaria){
            if(objetoDaLista.getModelo().equals(nomeDoCarro)){
                objetoDaLista.setAno(carroDTO.getAno());
                objetoDaLista.setCor(carroDTO.getCor());
                objetoDaLista.setMotor(carroDTO.getMotor());

                return objetoDaLista;
            }
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não encontrei");
    }
}
