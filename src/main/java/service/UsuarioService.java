package service;

import domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UsuarioRepository;
import service.exceptions.ObjectNotFoundException;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository userRepo;

    public List<Usuario> findAll() {
        return userRepo.findAll();
    }

    public Usuario findById(String id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Usuario não encontrado"));
    }

}
