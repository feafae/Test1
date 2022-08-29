package net.softsociety.exam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.exam.domain.LoginForm;
import net.softsociety.exam.domain.Member;
import net.softsociety.exam.service.MemberSeviceImpl;

/**
 * 회원 정보 관련 콘트롤러
 */

@Slf4j
@RequiredArgsConstructor
@RequestMapping("member")
@Controller
public class MemberController {
	
	private final MemberSeviceImpl memberServicelmpl;
	
	
	@GetMapping(path = "/join")
	public String JoinForm(Model model,Member member) {
		model.addAttribute("member", member);
		return "member/jogin";
	}
	
	@PostMapping(value = "/join")
	public String join(@Validated @ModelAttribute("member")Member member, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "member/joinForm";
		}
		memberServicelmpl.saveMember(member.toMember());
		return "redirect:/";
	}
	
	@GetMapping(value = "login")
	public String loginForm(Model model,LoginForm loginForm) {
		model.addAttribute("loginForm", loginForm);
		return "member/loginForm";
	}
	@PostMapping(value = "/login")
    public String login(@Validated @ModelAttribute("loginForm") LoginForm loginForm, BindingResult bindingResult, HttpServletRequest request) {
		if(bindingResult.hasErrors()) {
			return "member/loginForm";
		}
		Member findMember = memberServicelmpl.findMember(loginForm.toMember());
		if (findMember == null) {
            bindingResult.reject("loginError", "아이디 또는 패스워드가 맞지 않습니다.");
            return "member/loginForm";
        }
		HttpSession session = request.getSession();
        session.setAttribute("loginMember", findMember);
        return "redirect:/board/list";
	}
	@GetMapping(value = "/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }
}
