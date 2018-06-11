package com.webservices.restful.springbootrestfuldemo.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService userService;

	@GetMapping(path = "/users")
	public List<User> findall() {
		return userService.findAll();
	}

	@GetMapping(path = "/users/{id}")
	public User findOne(@PathVariable Integer id) {
		User user = userService.findOne(id);
		
		if(user == null) {
			throw new ResourceNotFoundException("id-"+id);
		}
		return user;
	}

	@PostMapping(path = "/users")
	public ResponseEntity saveUser(@RequestBody User user) {

		User saveduser = userService.saveOne(user);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(saveduser.getId())
				.toUri();
		return ResponseEntity.created(location).build();

	}

}
