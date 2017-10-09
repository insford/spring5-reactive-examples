package com.insford.spring5.repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.insford.spring5.domain.Customer;
import com.insford.spring5.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class UserRepository {
	Logger logger = LoggerFactory.getLogger(getClass());

	public Mono<User> findUser(Long id) {
		return Mono.justOrEmpty(createMock(id));
	}

	public Flux<User> findAll() {
		List<User> users = Arrays.asList(
			createMock(1L),
			createMock(2L),
			createMock(3L),
			createMock(4L),
			createMock(5L)
		);
		return Flux.fromIterable(users);
	}

	private User createMock(Long id) {
		List<Customer> customers = Arrays.asList(
			new Customer(id + 100, id + 100 + "_customers"),
			new Customer(id + 200, id + 200 + "_customers"),
			new Customer(id + 300, id + 300 + "_customers")
		);
		return new User(id, id + "_name", customers);
	}

}
