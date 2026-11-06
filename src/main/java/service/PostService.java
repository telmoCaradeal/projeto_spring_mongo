package service;

import domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PostagemRepository;
import service.exceptions.ObjectNotFoundException;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostagemRepository postRepository;

    public Post findById(String id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Post não encontrado"));
    }

    public List<Post> findByTitle(String text) {
        return postRepository.findByTituloContainingIgnoreCase(text);
    }
}
