
package com.moto_service.moto_service.service;

import com.moto_service.moto_service.Repository.MotoRepository;
import com.moto_service.moto_service.entidades.Moto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotoService {
    
    @Autowired
    private MotoRepository motoRepository;
    
    
    public List<Moto> getAll(){
        return motoRepository.findAll();
    }
    
    public Moto getUsuarioById(int id){
        return motoRepository.findById(id).orElse(null);
    }
    
    public Moto save(Moto moto){
        Moto nuuevo_moto = motoRepository.save(moto);
        return nuuevo_moto;
    }
    
    public List<Moto> findByUsuario(int idUsuario){
        return motoRepository.findByUsuarioId(idUsuario);
    }
}
