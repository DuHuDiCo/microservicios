package com.moto_service.moto_service.Controllers;

import com.moto_service.moto_service.entidades.Moto;
import com.moto_service.moto_service.service.MotoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/moto")
public class MotoController {

    
    @Autowired
    private MotoService motoService;
    
    
     @GetMapping("/")
    public ResponseEntity<List<Moto>> listarMotos() {
        List<Moto> motos = motoService.getAll();
        if (motos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motos);
    }
    
    
     @GetMapping("/{id}")
    public ResponseEntity<Moto> obtenerMoto(@PathVariable("id") int id) {
        Moto moto = motoService.getUsuarioById(id);
        if (moto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(moto);
    }
    
    
    @PostMapping("/")
    public ResponseEntity<Moto> guardarMoto(@RequestBody Moto moto) {
        Moto mot = motoService.save(moto);
        return ResponseEntity.ok(mot);
    }
    
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Moto>> obtenerMotosByIdUsuario(@PathVariable("usuarioId") int usuarioId) {
        System.out.println(usuarioId);
        List<Moto> motos = motoService.findByUsuario(usuarioId);
        if(motos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motos);
    }


}
