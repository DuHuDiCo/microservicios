

package com.usuario_service.usuario_service.feingsClients;

import com.usuario_service.usuario_service.models.Moto;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "moto-service", url = "http://localhost:8003/moto")
public interface MotoFeignClient {

    
     @PostMapping("/")
    public Moto save(@RequestBody Moto moto);
    
    @GetMapping("/usuario/{usuarioId}")
    public List<Moto> getMotos(@PathVariable("usuarioId") int usuarioId);
}
