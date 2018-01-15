package com.sonandhan.boardit.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	private UserService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws Exception {

		logger.info("home");

		List<UserDTO> memberList = service.selectMember();

		model.addAttribute("memberList", memberList);

		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "login";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

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
		 * 작업 부분은 command한테 시키면 됨
		 */
		command = new BIListCommand();
		command.execute(model);

		return "list";
	}

	@RequestMapping("/write_view")
	public String write_view(Model model) {

		System.out.println("write_view()");
		// 작성 화면(form)만 띄움
		return "write_view";
	}

	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		// 실제 작성
		System.out.println("write()");
		model.addAttribute("request", request);
		command = new BIWriteCommand();
		command.execute(model);

		// 작성하고 나면 다시 리스트 화면으로 이동
		return "redirect:list";
	}

	@RequestMapping("content_view")
	public String content_view(HttpServletRequest request, Model model) {
		// 컨텐츠를 클릭했을때 콘텐츠를 띄움
		System.out.println("cotent_view()");
		model.addAttribute("request", request);
		command = new BIContentCommand();
		command.execute(model); // 컨텐츠를 보이기 위해서 실제로 데이터를 가져오는건 execute() 안에 작성
		return "contet_view";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/modify")
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("modify()");

		model.addAttribute("reqeust", request);
		command = new BIModifyCommand();
		command.execute(model);

		// 수정 후에는 다시 리스트 화면으로 이동
		return "redirect:list";
	}

	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {
		System.out.println("reply_view()");

		model.addAttribute("request", request);

		// Reply 뷰 보는 리퀘스튼데,
		// 우리꺼는 필요 없는거 같아서 일단 제외
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
