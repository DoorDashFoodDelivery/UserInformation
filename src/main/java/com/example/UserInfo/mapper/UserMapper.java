package com.example.UserInfo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.UserInfo.dto.UserDTO;
import com.example.UserInfo.entity.User;

@Mapper
public interface UserMapper {

	UserMapper INSTANCE=Mappers.getMapper(UserMapper.class);
	
	User mapUserDTOToUser(UserDTO userDTO);
	
	UserDTO mapUserToUserDTO(User user);
}
