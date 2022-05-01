package com.example.springsecurityjpah2.service;



import com.example.springsecurityjpah2.dto.UserDto;
import com.example.springsecurityjpah2.entity.User;
import com.example.springsecurityjpah2.repo.UserRepo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
@Builder
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;

	@Override
	public UserDto save(UserDto dto) {
		User user;
		if (dto.getId() != null && dto.getId() != 0) {
			user = userRepo.findUserById(dto.getId()); //from repo, created by programmer
		} else {
			user = new User();
		}
		user.setId(dto.getId());
		user.setUsername(dto.getUsername());
		user.setRoles(dto.getRole());
		user.setPassword(dto.getPassword());

		userRepo.save(user); // repo takes entity inbuilt method provided by Jpa
		return dto;
	}

	@Override
	public List<User> findAll() {
		return (List<User>) userRepo.findAll();  //becasue directly fetching from repo
	}
}
