package rokomari.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import rokomari.project.model.Users;

public interface UserRepository extends JpaRepository<Users, Long>{
	Optional <Users> findByName(String name);

}
