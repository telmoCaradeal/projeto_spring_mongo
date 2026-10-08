package resources;


import domain.Usuario;
import dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.UsuarioService;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResources {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UsuarioDTO>> findAll(){
//Codigo para testar o EndPoint passando uma lista feita no hardcode
//        List<Usuario> list = new ArrayList<>();
//        Usuario maria = new Usuario("1001", "Maria Brown", "maria@gmail.com");
//        Usuario alex = new Usuario("1002", "Alex Green", "alex@gmail.com");
//        list.addAll(Arrays.asList(maria, alex));
//        return ResponseEntity.ok().body(list);

        List<Usuario> listaUsuarios = usuarioService.findAll();
        List<UsuarioDTO> listaUsuariosDTO = listaUsuarios.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listaUsuariosDTO);

    }

}
