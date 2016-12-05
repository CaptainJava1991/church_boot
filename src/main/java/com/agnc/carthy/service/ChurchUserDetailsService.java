package com.agnc.carthy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.agnc.carthy.model.User;
import com.agnc.carthy.repository.UserRepository;

public class ChurchUserDetailsService implements UserDetailsService {

	private UserRepository userRepository;
	
    @Autowired
    public ChurchUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
	
	@Override
	public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        try {
        	System.out.println("avant");
        	System.out.println("apres");
        	User user = userRepository.findByMail(mail);
            System.out.println(user.getUsername());
            return userRepository.findByMail(mail);
            
        }
        catch (Exception e){
            throw new UsernameNotFoundException("User not found");
        }
	}

}
