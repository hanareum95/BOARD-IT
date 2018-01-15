package com.sonandhan.boardit.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.sonandhan.boardit.dao.BIDao;
import com.sonandhan.boardit.dto.BIDto;

public class BIListCommand implements BICommand {

	// db에 접근해서 데이터를 가져와 화면에 뿌려줌
	// 즉, JSP 페이지에 DTO 객체를 넘겨서
	// JSP 페이지가 DTO 객체로부터 데이터를 뿌리는 작업

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		BIDao dao = new BIDao();
		ArrayList<BIDto> dtos = dao.list();

		model.addAttribute("list", dtos);
		dao.list();

	}

}
