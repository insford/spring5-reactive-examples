package com.insford.spring5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.insford.spring5.domain.Customer;
import com.insford.spring5.domain.User;
import com.insford.spring5.repository.UserRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserRepository userRepository;

	public UserController(@Autowired UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping("/{id}")
	public Mono<User> getUser(@PathVariable Long id) {
		return userRepository.findUser(id);
	}

	@GetMapping("/{id}/customers")
	public Flux<Customer> getCustomers(@PathVariable Long id) {
		return userRepository.findUser(id)
			.flatMapIterable(User::getCustomers);
	}
}
