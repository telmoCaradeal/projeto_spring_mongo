package resources;



import domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import resources.util.URL;
import service.PostService;

import java.util.List;


@RestController
@RequestMapping(value="/post")
public class PostResources {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post postId = postService.findById(id);
        return ResponseEntity.ok().body(postId);

    }

    @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){
        text = URL.decodeParm(text);
        List<Post> lista = postService.findByTitle(text);
        return ResponseEntity.ok().body(lista);

    }


}
