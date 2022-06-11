package com.mytelecom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mytelecom.repository.UserRepository;
import com.mytelecom.repository.entity.MyTelecomUser;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		Optional<MyTelecomUser> user = userRepo.findById(id);
		if (user.isEmpty()) {
			throw new UsernameNotFoundException("User not found with username: " + id);
		}
		return new org.springframework.security.core.userdetails.User(user.get().getId(), user.get().getPassword(),
				List.of(new SimpleGrantedAuthority("USER")));
	}
	
	public MyTelecomUser save(MyTelecomUser user) {
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userRepo.save(user);
	}
}