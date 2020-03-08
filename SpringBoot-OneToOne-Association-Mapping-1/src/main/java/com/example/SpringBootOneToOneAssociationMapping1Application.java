package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.repo.UserDetailRepo;
import com.example.repo.UsersRepo;
import com.example.user.Users;
import com.example.user.UsersDetail;

@SpringBootApplication
public class SpringBootOneToOneAssociationMapping1Application {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootOneToOneAssociationMapping1Application.class, args);
		UsersRepo usersRepo = ctx.getBean(UsersRepo.class);
		UserDetailRepo userDetailRepo = ctx.getBean(UserDetailRepo.class);
		
		Users users=new Users();
		users.setName("wasim");
		users.setPhone(98765432l);
 
		UsersDetail ud=new UsersDetail();
		
		Users savedUser = usersRepo.save(users);
		ud.setUsers(savedUser);
		ud.setAddress("Hyd");
		
		UsersDetail savedUserDtls = userDetailRepo.save(ud);
		
		System.out.println(savedUserDtls);
	
		
		
	}

}
