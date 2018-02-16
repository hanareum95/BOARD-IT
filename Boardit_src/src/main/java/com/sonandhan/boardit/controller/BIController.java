package com.sonandhan.boardit.controller;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sonandhan.boardit.HomeController;
import com.sonandhan.boardit.command.BICommand;
import com.sonandhan.boardit.command.BIContentCommand;
import com.sonandhan.boardit.command.BIDeleteCommand;
import com.sonandhan.boardit.command.BIListCommand;
import com.sonandhan.boardit.command.BIModifyCommand;
import com.sonandhan.boardit.command.BIReplyCommand;
import com.sonandhan.boardit.command.BIWriteCommand;
import com.sonandhan.boardit.dto.UserDTO;
import com.sonandhan.boardit.service.UserService;

@Controller
public class BIController {

	BICommand command;

	private static final Logger logger = LoggerFactory.getLogger(BIController.class);
	@Inject
	private UserService user_service;

	// 로그인 처리
	@RequestMapping(value = "/board")
	public String board(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws Exception {

		logger.info("board");

		UserDTO loginUser = user_service.findByUserIdAndPassword(request.getParameter("userId"),
				request.getParameter("userPassword"), session);
		System.out.println(">>BIController - login(POST)");
		System.out.println(">>BIController - loginUser : " + loginUser);

		if (loginUser != null) { // login success
			System.out.println(">>BIController - session msg : success");
			
			session.setAttribute("userLoginInfo", loginUser);
			return "board";
		} else { // login failure
			System.out.println(">>BIController - session msg : failure");
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인 정보를 확인해주세요.'); history.go(-1);</script>");
			out.flush();
			return "login";
		}
	}

	// 로그아웃
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("userLoginInfo", null);
		return "redirect:login";
	}

	@RequestMapping("/pop_board")
	public String popBoard(Model model) {

		System.out.println("pop_board()");
		// 작성 화면(form)만 띄움
		return "pop_board";
	}

	// 로그인 화면
	@RequestMapping(value = "/login")
	public String login(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "login";
	}

	// 회원가입 페이지 이동 후
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		System.out.println(">>BIController - signup(GET)");
		return "signup";
	}

	// 회원가입 버튼 누른 후 DB삽입
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(Locale locale, Model model, HttpServletRequest request) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		UserDTO user = new UserDTO(request.getParameter("userName"), request.getParameter("userId"),
				request.getParameter("userPassword"));

		System.out.println(">>BIController - signup(POST)");
		System.out.println(">>BIController - signup(POST) user : " + user.getUserName());
		user_service.signupUser(user);

		return "signup";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "profile";
	}

	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
		/**
		 * �옉�뾽 遺�遺꾩� command�븳�뀒 �떆�궎硫� �맖
		 */
		command = new BIListCommand();
		command.execute(model);

		return "list";
	}

	@RequestMapping("/write_view")
	public String write_view(Model model) {

		System.out.println("write_view()");
		// �옉�꽦 �솕硫�(form)留� �쓣��
		return "write_view";
	}

	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		// �떎�젣 �옉�꽦
		System.out.println("write()");
		model.addAttribute("request", request);
		command = new BIWriteCommand();
		command.execute(model);

		// �옉�꽦�븯怨� �굹硫� �떎�떆 由ъ뒪�듃 �솕硫댁쑝濡� �씠�룞
		return "redirect:list";
	}

	@RequestMapping("content_view")
	public String content_view(HttpServletRequest request, Model model) {
		// 而⑦뀗痢좊�� �겢由��뻽�쓣�븣 肄섑뀗痢좊�� �쓣��
		System.out.println("cotent_view()");
		model.addAttribute("request", request);
		command = new BIContentCommand();
		command.execute(model); // 而⑦뀗痢좊�� 蹂댁씠湲� �쐞�빐�꽌 �떎�젣濡� �뜲�씠�꽣瑜�
								// 媛��졇�삤�뒗嫄� execute() �븞�뿉 �옉�꽦
		return "contet_view";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/modify")
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("modify()");

		model.addAttribute("reqeust", request);
		command = new BIModifyCommand();
		command.execute(model);

		// �닔�젙 �썑�뿉�뒗 �떎�떆 由ъ뒪�듃 �솕硫댁쑝濡� �씠�룞
		return "redirect:list";
	}

	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {
		System.out.println("reply_view()");

		model.addAttribute("request", request);

		// Reply 酉� 蹂대뒗 由ы�섏뒪�듉�뜲,
		// �슦由ш볼�뒗 �븘�슂 �뾾�뒗嫄� 媛숈븘�꽌 �씪�떒 �젣�쇅
		// command = new BIReplyViewCommand();
		// command.execute(model);
		return "reply_view";
	}

	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model) {
		System.out.println("reply()");

		model.addAttribute("reauest", request);
		command = new BIReplyCommand();
		command.execute(model);

		return "redirect:list";
	}

	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("delete()");

		model.addAttribute("request", request);
		command = new BIDeleteCommand();
		command.execute(model);

		return "redirect:list";
	}

}
