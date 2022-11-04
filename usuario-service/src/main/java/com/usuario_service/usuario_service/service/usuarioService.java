
package com.usuario_service.usuario_service.service;

import com.usuario_service.usuario_service.feingsClients.CarroFeignClient;
import com.usuario_service.usuario_service.feingsClients.MotoFeignClient;
import com.usuario_service.usuario_service.models.Carro;
import com.usuario_service.usuario_service.models.Moto;
import com.usuario_service.usuario_service.models.Usuario;
import com.usuario_service.usuario_service.repository.UsuarioRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UsuarioService {
    
    
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CarroFeignClient carroFeignClient;

    @Autowired
    private MotoFeignClient motofeignClient;

    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(int id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario save(Usuario usuario) {
        Usuario nuuevo_usuario = usuarioRepository.save(usuario);
        return nuuevo_usuario;
    }

    //RestTemplate
    public List<Carro> getCarros(int usuarioId) {
        List<Carro> carros = restTemplate.getForObject("http://localhost:8002/carro/usuario/" + usuarioId, List.class);
        return carros;
    }

    public List<Moto> getMotos(int usuarioId) {
        List<Moto> motos = restTemplate.getForObject("http://localhost:8003/moto/usuario/" + usuarioId, List.class);
        return motos;
    }

    //ForeignClient
    public Carro saveCarro(int usuarioId, Carro carro) {
        carro.setUsuarioId(usuarioId);
        Carro nuevoCarro = carroFeignClient.save(carro);
        return nuevoCarro;
    }

    public Moto saveMoto(int usuarioId, Moto moto) {
        moto.setUsuarioId(usuarioId);
        Moto nuevaMoto = motofeignClient.save(moto);
        return nuevaMoto;
    }

    public Map<String, Object> getUsuarioAndVehiculos(int usuarioId) {
        Map<String, Object> resultado = new HashMap<>();
        Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);

        if (usuario == null) {
            resultado.put("Mensaje", "El Usuario no Existe");
        } else {
            resultado.put("Usuario", usuario);
        }

        List<Carro> carros = carroFeignClient.getCarros(usuarioId);
        if (carros.isEmpty()) {
            resultado.put("Mensaje", "El Usuario no Tiene Carros");
        } else {
            resultado.put("Carros", carros);
        }
        List<Moto> motos = motofeignClient.getMotos(usuarioId);
        if (motos.isEmpty()) {
            resultado.put("Mensaje", "El Usuario no Tiene Motos");
        } else {
            resultado.put("Motos", motos);
        }
        return resultado;
    }

}
