package com.example.UserInfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UserInfo.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;
}
