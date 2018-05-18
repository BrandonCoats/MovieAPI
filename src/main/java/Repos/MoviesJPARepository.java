package Repos;
import java.util.List;
import java.util.Optional;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import Models.Movie;


public interface MoviesJPARepository extends JpaRepository<Movie,Integer>{

	@Lock(LockModeType.PESSIMISTIC_WRITE)
	Optional<Movie> findById(Integer id);
	
	List<Movie> findByTitle(String name);

	List<Movie> findByTitleLike(String name);

	
}
