package repository;

import domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostagemRepository extends MongoRepository<Post, String> {

    List<Post> findByTituloContainingIgnoreCase(String text);

}
