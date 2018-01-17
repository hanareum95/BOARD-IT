package com.sonandhan.boardit.dao;

import java.util.*;

import com.sonandhan.boardit.dto.UserDTO;

public interface UserDAO {
	public List<UserDTO> selectMember() throws Exception;
//	public HashMap<String, Object> selectOne(String id);
	
	//TODO:: add
	public int insertMember(UserDTO user);
//	public int updateMember(HashMap<String, Object> params);
//	public int deleteMember(String id);	
}
