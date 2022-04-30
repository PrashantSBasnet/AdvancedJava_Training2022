package service;

import com.example.springsecurityjpah2.dto.UserDto;
import com.example.springsecurityjpah2.entity.User;

import java.util.List;

public interface UserService {

	public List<User> findAll();

	UserDto save(UserDto userDto) throws Exception;
	

}
