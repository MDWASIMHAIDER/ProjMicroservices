package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.repo.UserDetailRepo;
import com.example.repo.UsersRepo;
import com.example.user.Users;
import com.example.usersdetail.UsersDetail;

@SpringBootApplication
public class SpringBootOneToOneAssociationMappingApplication {
	@Autowired
	private static UsersRepo repo1;
	
	@Autowired
	private static UserDetailRepo repo2;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootOneToOneAssociationMappingApplication.class, args);
		Users users=new Users();
		users.setName("wasim");
		users.setPhone(98765432l);
		UsersDetail ud=new UsersDetail();
		//Users savedUser = repo1.save(users);
		ud.setUsers(users);
		ud.setAddress("Hyd");
		
		UsersDetail savedUserDtls = repo2.save(ud);
		
		System.out.println(savedUserDtls);
	
		
		
	}

}
