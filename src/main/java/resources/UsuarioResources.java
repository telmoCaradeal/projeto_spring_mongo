package resources;


import domain.Usuario;
import dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import service.UsuarioService;


import java.net.URI;
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

        List<Usuario> listaUsuarios = usuarioService.findAll();
        List<UsuarioDTO> listaUsuariosDTO = listaUsuarios.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listaUsuariosDTO);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UsuarioDTO> findById(@PathVariable String id){
        Usuario usuarioId = usuarioService.findById(id);
        return ResponseEntity.ok().body(new UsuarioDTO(usuarioId));

    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insertDto(@RequestBody UsuarioDTO usuarioDTO){
        Usuario obj = usuarioService.fromDTO(usuarioDTO);
        obj = usuarioService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


}
