package com.sonandhan.boardit.dao;

import java.util.List;

import com.sonandhan.boardit.dto.UserDTO;

public interface UserDAO {
	public List<UserDTO> selectMember() throws Exception;
}
