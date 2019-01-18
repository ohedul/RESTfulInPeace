package rokomari.project.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rokomari.project.model.Users;
import rokomari.project.repository.RoleRepository;
import rokomari.project.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public void save(Users user) {
		user.setRoles(new HashSet<> (roleRepository.findAll()));
		userRepository.save(user);
	}
	
	@Override
	public Users findByUserNmae(String username) {
		return userRepository.findByUserName(username);
	}

}
