package com.sonandhan.boardit.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.sonandhan.boardit.dao.UserDAO;
import com.sonandhan.boardit.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService {

	@Inject
	private UserDAO dao;

	@Override
	public List<UserDTO> selectMember() throws Exception {
		return dao.selectMember();
	}

	@Override
	public void signupUser(UserDTO user){
		dao.insertMember(user);
	}

	@Override
	public UserDTO findByUserIdAndPassword(String userId, String password, HttpSession session) {
		UserDTO dto = dao.findByUserIdAndPassword(userId, password, session);
		return dto;
	}
	
}
