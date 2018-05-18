package Repos;

import java.util.List;
import java.util.Optional;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import Models.User;

public interface UserJPARepository extends JpaRepository<User,Integer>{

	@Lock(LockModeType.PESSIMISTIC_WRITE)
	Optional<User> findById(Integer id);


	
}