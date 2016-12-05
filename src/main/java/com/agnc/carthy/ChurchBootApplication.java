package com.agnc.carthy;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.agnc.carthy.model.Authority;
import com.agnc.carthy.model.User;
import com.agnc.carthy.repository.AuthorityRepository;
import com.agnc.carthy.repository.UserRepository;

@SpringBootApplication
public class ChurchBootApplication {

    private static UserRepository userRepository = null;
    private static AuthorityRepository authorityRepository = null;

    @Autowired
    private static DataSource dataSource;

    @Autowired
    public ChurchBootApplication(UserRepository userRepository, AuthorityRepository authorityRepository){
    	ChurchBootApplication.userRepository = userRepository;
    	ChurchBootApplication.authorityRepository = authorityRepository;
    }
	
	public static void main(String[] args) {
		SpringApplication.run(ChurchBootApplication.class, args);
		User u = new User();
        u.setMail("test@lol.com");
        u.setPassword("rootdata");
        u.setUsername("root");
        u.setFirstname("data");
        u.setEnabled(true);

        Authority a = new Authority();
        a.setUser(u);
        a.setAuthority("ROLE_ADMIN");

        userRepository.save(u);
        authorityRepository.save(a);
	}

}
