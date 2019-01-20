package rokomari.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import rokomari.project.model.CustomUserDetails;
import rokomari.project.model.Users;
import rokomari.project.repository.UserRepository;
/*
 * This class will be used by spring security
 * To do that we inject this into ConfigurationSecurity class
 */
@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		Optional<Users> optionalUsers = userRepository.findByName(arg0);
		
		if(optionalUsers == null) {
			throw new UsernameNotFoundException("User name not found.");
		}
		
		return optionalUsers.map(CustomUserDetails :: new).get();
	}
	
	

}
