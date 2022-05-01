package com.example.springsecurityjpah2.controller;


import com.example.springsecurityjpah2.dto.UserDto;
import com.example.springsecurityjpah2.entity.User;
import com.example.springsecurityjpah2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/secure/auth")
public class AdminController {

	@Autowired
	UserService userService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@GetMapping("/user")
	public ResponseEntity<List<User>> getUsers() {

		return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
	}

	//@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping("/admin/add")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) throws Exception {
		String pwd = userDto.getPassword();
		String encrypt = passwordEncoder.encode(pwd);
		userDto.setPassword(encrypt);
		return new ResponseEntity<UserDto>(userService.save(userDto), HttpStatus.OK);
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/admin/all")
	public String securedHello() {
		return "Secured Hello";
	}
}