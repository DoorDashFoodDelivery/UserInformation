package com.example.UserInfo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.UserInfo.dto.UserDTO;
import com.example.UserInfo.entity.User;
import com.example.UserInfo.mapper.UserMapper;
import com.example.UserInfo.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;

	public UserDTO addUser(UserDTO userDTO) {
		User savedUser=userRepo.save(UserMapper.INSTANCE.mapUserDTOToUser(userDTO));
		return UserMapper.INSTANCE.mapUserToUserDTO(savedUser);
	}

	public ResponseEntity<UserDTO> fetchUserDetailsById(Integer userId) {
	Optional<User>fetchUser=userRepo.findById(userId);
	
	if (fetchUser.isPresent()) {
		return new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDTO(fetchUser.get()) , HttpStatus.OK);
	}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
}
