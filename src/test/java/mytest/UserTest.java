package mytest;

import hahamongodb.MongoHa.like.User;
import hahamongodb.MongoHa.like.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:haha.xml" })
public class UserTest {
	@Autowired
	private UserRepository userRepository;

	@Test
	public void findAll() {
		for (User user : userRepository.findAll()) {
			System.out.println(user.getEmail());
		}
	}

	@Test
	public void findByEmail() {
		for (User user : userRepository.findByEmail("libinsbox@137.com")) {
			System.out.println(user.getUserName());
		}
	}

	@Test
	public void findById() {

		System.out.println(userRepository.findOneByUserId("libinsbox@138.com")
				.getUserName());

	}

}
