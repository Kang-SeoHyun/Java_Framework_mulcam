package com.multicampus.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.multicampus.biz.user.UserDAOJDBC;
import com.multicampus.biz.user.UserVO;

@Controller
public class LoginController {
	
	// �α׾ƿ�
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:/";
	}

	// �α��� ȭ������ �̵�
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserVO vo) throws Exception {
		vo.setId("test");
		vo.setPassword("test");
		return "login";
	}
	
	// �α��� ó��
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(UserVO vo, UserDAOJDBC dao, HttpSession session) throws Exception {
		UserVO user = dao.getUser(vo);
		if(user != null) {	// �α��� ����
			session.setAttribute("user", user);			
			return "forward:getBoardList.do";
		} else return "login";
	}

}









