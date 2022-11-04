
package com.usuario_service.usuario_service.repository;

import com.usuario_service.usuario_service.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
