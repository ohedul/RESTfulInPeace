package rokomari.project.userDetail;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import rokomari.project.model.Role;
import rokomari.project.model.Users;
import rokomari.project.repository.UserRepository;

@Service
public class UserDetail implements UserDetailsService{
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Users user = userRepository.findByUserName(userName);
		Set<GrantedAuthority> grantedAuthorites = new HashSet<>();
		for(Role role : user.getRoles()) {
			grantedAuthorites.add(new SimpleGrantedAuthority(role.getName()));
		}
		
		return new org.springframework.security.core.userdetails.User(user.getFirst_name(), user.getPassword(), grantedAuthorites);
	}
	
	

}
