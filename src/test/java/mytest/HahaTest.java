package mytest;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import hahamongodb.MongoHa.like.User;
import hahamongodb.MongoHa.like.UserRepository;

public class HahaTest {
	private static final Logger log = LoggerFactory.getLogger(HahaTest.class);

	public HahaTest() {

	}

	public void logInfo(final String ss) {
		log.info(ss);
	}

	public void logWarn(final String ss) {
		log.warn(ss);
	}

	public void logError(final String ss) {
		log.error(ss);
	}

	public static void main(String args[]) {
		final HahaTest hahaTest = new HahaTest();
		final AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:haha.xml");
	//	User user = new User();
		final UserRepository userRepository = applicationContext.getBean(UserRepository.class);
		if (null == userRepository) {
			throw new NullPointerException();
		}

//		for (int i = 0; i < 10; i++) {
//			user.setUserId("liuxin" + i);
//			user.setEmail("liuxin@unitedcloud.com");
//			user.setUserName("I am liuxin " + i);
//			user.setSex("boy");
//			user.setBirthday(new Date());
//			userRepository.save(user);
//			hahaTest.logInfo(user.toString());
//		}
		userRepository.deleteAll();
		
		//List<User> list=userRepository.findAll(ids).findAll();
//		
//		
//		final Iterator<User> iterator=list.iterator();
//		User user=null;
//		while(iterator.hasNext()){
//			user=iterator.next();
//			if(null!=user){
//			System.out.println(user);
//			}
//		}
		
		
		
		
		

	}

}
