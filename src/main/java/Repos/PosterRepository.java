package Repos;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import Models.Poster;

public interface PosterRepository extends MongoRepository<Poster, String> {

    public Optional<Poster> findById(Integer id);
    public Optional<Poster> findByTitle(String movieTitle);

}
