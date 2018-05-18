package Repos;

import java.util.List;
import java.util.Optional;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import Models.Actor;

public interface ActorsJPARepository extends JpaRepository<Actor,Integer>{

	@Lock(LockModeType.PESSIMISTIC_WRITE)
	Optional<Actor> findById(Integer id);
	
	List<Actor> findByName(String name);

	List<Actor> findByNameLike(String name);

	
}