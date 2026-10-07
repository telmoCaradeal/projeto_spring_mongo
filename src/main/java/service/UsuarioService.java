package service;

import domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import repository.UsuarioRepository;

import java.util.List;

public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

}
