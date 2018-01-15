package com.sonandhan.boardit.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sonandhan.boardit.dto.UserDTO;

@Repository
public class UserDAOImpl implements UserDAO{

	@Inject
	private SqlSession sqlSession;

	private static final String Namespace = "com.example.mapper.userMapper";

	@Override
	public List<UserDTO> selectMember() throws Exception {

		return sqlSession.selectList(Namespace + ".selectUser");
	}

}
