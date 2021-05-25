package local.core.mart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import local.core.mart.config.UserDetailsImpl;
import local.core.mart.entities.Role;
import local.core.mart.entities.User;
import local.core.mart.repos.RoleRepo;
import local.core.mart.repos.UserRepo;
 
public class UserServiceImpl implements UserDetailsService {
 
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RoleRepo roleRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = userRepo.getUserByUsername(username);
		 
		if (user == null) {
			throw new UsernameNotFoundException("Could not find user");
		}
		 
		return new UserDetailsImpl(user);
	}
	
	
	public User createBasicUser(User user) {
		user = userRepo.save(user);
		return user;
	}
	
	public User getUser( String userName) {
		User user = userRepo.getUserByUsername(userName);
		return user;
	}
	
	public User addRole(String username, String rolename) {
		User user = userRepo.getUserByUsername(username);
		Role role = roleRepo.getRoleByRolename(rolename);
		userRepo.addRole(user.getId(), role.getId());
		return user;
	}
 
}