package com.sonandhan.boardit.service;

import java.util.HashMap;
import java.util.List;

import com.sonandhan.boardit.dto.UserDTO;

public interface UserService {

	public List<UserDTO> selectMember() throws Exception;
	
	//TODO:: add
	public void signupUser(UserDTO user);

}
