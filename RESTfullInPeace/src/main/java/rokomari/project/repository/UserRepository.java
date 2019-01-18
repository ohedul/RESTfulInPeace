package rokomari.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rokomari.project.model.Users;

public interface UserRepository extends JpaRepository<Users, Long>{
	Users findByUserName(String username);

}
