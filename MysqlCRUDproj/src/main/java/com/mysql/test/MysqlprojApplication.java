package com.mysql.test;

import java.util.List;
import java.util.*;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mysql.test.dao.UserRepository;
import com.mysql.test.entities.User;

@SpringBootApplication
public class MysqlprojApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(MysqlprojApplication.class, args);
		
		UserRepository userRepository = context.getBean(UserRepository.class);
		
		//create
		
		User user = new User();
		user.setName("Umakant Patel");
		user.setCity("Bhopal");
		user.setStatus("I am java programmer");
		
		User user1 = userRepository.save(user);
		
		System.out.println(user1); 
		
		
		User user1 = new User();
		user1.setName("Umakant Patel");
		user1.setCity("Bhopal");
		user1.setStatus("I am java programmer");
		
		User user2 = new User();
		user2.setName("Yogesh");
		user2.setCity("Indore");
		user2.setStatus("I am Accountant");
		
		//saving single user 
		//User resultUser = userRepository.save(user1);
		
		//saving multiple objects by using saveAll method
		List<User> users = List.of(user1,user2);
		Iterable<User> result = userRepository.saveAll(users);
		
		result.forEach(user->{
			System.out.println(user);
		});
		
		//read
		
		//get the particular data id you want to get all data the use findAll() iterare using forEach
		Optional<User> optionalget = userRepository.findById(3);
		User userget = optionalget.get(); 
		System.out.println(userget);
		
		Iterable<User> itr = userRepository.findAll();
		//print all users by using lamda function
		itr.forEach(user->{System.out.println(user);});
		
		//update
		
		//update the particular user by id
//		Optional<User> optional = userRepository.findById(2);
//		User user = optional.get();
//		
//		user.setCity("Delhi");
//		
//		User result = userRepository.save(user);
//		
//		System.out.println(result);
		
		//delete
		
		//deleting the partictlar user by id
//		userRepository.deleteById(3);
//		System.out.println("id 3 user deleted");
		
		// deleteing all users
		
//		Iterable<User> allUsers = userRepository.findAll();
//		
//		allUsers.forEach(user->System.out.println(user));
//		
		
	}

}
