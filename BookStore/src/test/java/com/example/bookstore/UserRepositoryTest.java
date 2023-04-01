package com.example.bookstore;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.bookstore.domain.User;
import com.example.bookstore.domain.UserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void findByUsernametest() {
		User UserTest1 = userRepository.findByUsername("user");
		assertThat(UserTest1).isNotNull();
	}
	
	@Test
	public void createUsertest () {
		User testuser = new User ("testuser", "testuser@gmail.com","$2a$10$LEcWQ/10C2NG8kc2McaVUuwPWzPObzFfMQ8eC1aAaQjOhOhTGRP.y", "USER");
		userRepository.save(testuser);
		assertThat(testuser.getId()).isNotNull();
		
	}
	
	public void deleteUsertest() {
		long deleteduser = userRepository.deleteByUsername("user");
		assertThat(deleteduser).isEqualTo(1);
	}
	

}
