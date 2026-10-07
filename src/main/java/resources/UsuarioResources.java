package resources;


import domain.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResources {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> findAll(){
        List<Usuario> list = new ArrayList<>();
        Usuario maria = new Usuario("1001", "Maria Brown", "maria@gmail.com");
        Usuario alex = new Usuario("1002", "Alex Green", "alex@gmail.com");
        list.addAll(Arrays.asList(maria, alex));
        return ResponseEntity.ok().body(list);
    }

}
