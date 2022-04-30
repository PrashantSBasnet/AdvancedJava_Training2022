package com.example.springsecurityjpah2.dto;

import com.example.springsecurityjpah2.entity.Role;
import com.example.springsecurityjpah2.entity.User;
import lombok.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    public Integer id;

    public String username;

    public String password;

    public Set<Role> role;

    private Integer bidId;

    public UserDto(User entity) {
        this.setId(entity.getId());
        this.setPassword(entity.getPassword());
        this.setRole(entity.getRoles());
        this.setUsername(entity.getUsername());
    }



    public List<UserDto> toDto(List<User> entityList) {
        List<UserDto> dtoList = new ArrayList<>();
        for (User user : entityList) {
            dtoList.add(new UserDto(user));
        }
        return dtoList;
    }

}