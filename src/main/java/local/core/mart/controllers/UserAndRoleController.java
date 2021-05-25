package local.core.mart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import local.core.mart.entities.User;
import local.core.mart.services.UserServiceImpl;

@RestController
@RequestMapping(value = "/admin, /maint", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserAndRoleController {
	@Autowired UserServiceImpl userService;
	
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public User addUser(User user) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		user = userService.createBasicUser(user);
		user.setPassword("********");
		return user;
	}
	
	@RequestMapping(value="/userRole", method = RequestMethod.POST)
	public User addRole(String username, String rolename) {
		User user = userService.addRole(username, rolename);
		return user;
	}
}
