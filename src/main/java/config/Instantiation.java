package config;

import domain.Post;
import domain.Usuario;
import dto.AutorDTO;
import dto.ComentarioDTO;
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

//        if (usuarioRepository.count() > 0) {
//            return;
//        }

        //Limpar a base de dados toda vez que executar essa classe
        usuarioRepository.deleteAll();
        postagemRepository.deleteAll();


        SimpleDateFormat  sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        Usuario maria = new Usuario(null, "Maria Brown", "maria@gmail.com");
        Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com");
        Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");
        usuarioRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("21/03/2026"), "Partiu Viagem", "Vou viajar para São Paulo. Abraços!", new AutorDTO(alex));
        Post post2 = new Post(null, sdf.parse("23/03/2026"), "Bom dia", "Acordei feliz hoje!", new AutorDTO(maria));

        ComentarioDTO coment1 = new ComentarioDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new AutorDTO(alex));
        ComentarioDTO coment2 = new ComentarioDTO("Aproveite!", sdf.parse("22/03/2018"), new AutorDTO(bob));
        ComentarioDTO coment3 = new ComentarioDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AutorDTO(alex));

        post1.getComentarios().addAll(Arrays.asList(coment1, coment2));
        post2.getComentarios().add(coment3);

        postagemRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        usuarioRepository.save(maria);

        alex.getPosts().addAll(Arrays.asList(post1, post2));
        usuarioRepository.save(alex);

    }
}
