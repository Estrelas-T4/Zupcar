package br.com.zup.Zupcar.carro;

import br.com.zup.Zupcar.carro.dtos.CarroDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarroService {
    private List<CarroDTO> concessionaria = new ArrayList<>();

    public List<CarroDTO> pegarTodosOsCarros(){
        return concessionaria;
    }

    public void salvarCarro(CarroDTO carroDTO){
        concessionaria.add(carroDTO);
    }

    public CarroDTO buscarCarro(String nomeDoCarro){
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

    public CarroDTO atualizarCarro(String nomeDoCarro, CarroDTO carroDTO){
        CarroDTO carro = buscarCarro(nomeDoCarro);
        carro.setAno(carroDTO.getAno());
        carro.setCor(carroDTO.getCor());
        carro.setMotor(carroDTO.getMotor());

        return carro;
    }
}
