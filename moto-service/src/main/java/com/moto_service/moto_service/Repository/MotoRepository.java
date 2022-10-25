

package com.moto_service.moto_service.Repository;

import com.moto_service.moto_service.entidades.Moto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotoRepository extends JpaRepository<Moto, Integer>{
    
    List<Moto> findByUsuarioId(int usuarioId);
}
