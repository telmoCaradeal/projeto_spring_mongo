package config;

import domain.Postagem;
import domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import repository.PostagemRepository;
import repository.UsuarioRepository;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PostagemRepository postagemRepository;




    @Override
    public void run(String... args) throws Exception {

        if (usuarioRepository.count() > 0) {
            return;
        }

        //Limpar a base de dados toda vez que executar essa classe
        usuarioRepository.deleteAll();
        postagemRepository.deleteAll();


        SimpleDateFormat  sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        Usuario maria = new Usuario(null, "Maria Brown", "maria@gmail.com");
        Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com");
        Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");
        usuarioRepository.saveAll(Arrays.asList(maria, alex, bob));

        Postagem post1 = new Postagem(null, sdf.parse("21/03/2026"), "Partiu Viagem", "Vou viajar para São Paulo. Abraços!", alex);
        Postagem post2 = new Postagem(null, sdf.parse("23/03/2026"), "Bom dia", "Acordei feliz hoje!", maria);
        postagemRepository.saveAll(Arrays.asList(post1, post2));

    }
}
