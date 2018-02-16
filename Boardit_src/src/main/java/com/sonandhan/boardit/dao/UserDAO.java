package com.sonandhan.boardit.dao;

import java.util.*;

import javax.servlet.http.HttpSession;

import com.sonandhan.boardit.dto.UserDTO;

public interface UserDAO {
	public List<UserDTO> selectMember() throws Exception;
	public int insertMember(UserDTO user);
	public UserDTO findByUserIdAndPassword(String userId, String password, HttpSession session);
}
