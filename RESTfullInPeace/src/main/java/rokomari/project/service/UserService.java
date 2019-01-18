package rokomari.project.service;

import rokomari.project.model.Users;

public interface UserService {

	void save(Users user);

	Users findByUserNmae(String username);

}
