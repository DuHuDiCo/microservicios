

package com.carro_service.carro_service.repository;

import com.carro_service.carro_service.entidades.Carro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Integer>{
    
    
    List<Carro> findByUsuarioId(int usuarioId);
}
