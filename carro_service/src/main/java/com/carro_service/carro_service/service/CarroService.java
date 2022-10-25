
package com.carro_service.carro_service.service;

import com.carro_service.carro_service.entidades.Carro;
import com.carro_service.carro_service.repository.CarroRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarroService {
    
    @Autowired
    private CarroRepository carroRepository;
    
    
    public List<Carro> getAll(){
        return carroRepository.findAll();
    }
    
    public Carro getUsuarioById(int id){
        return carroRepository.findById(id).orElse(null);
    }
    
    public Carro save(Carro carro){
        Carro nuuevo_carro = carroRepository.save(carro);
        return nuuevo_carro;
    }
    
    public List<Carro> findByUsuario(int idUsuario){
        return carroRepository.findByUsuarioId(idUsuario);
    }

}
