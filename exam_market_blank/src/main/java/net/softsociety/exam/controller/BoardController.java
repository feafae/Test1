package net.softsociety.exam.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.exam.dao.BoardDAO;
import net.softsociety.exam.domain.Board;
import net.softsociety.exam.domain.Member;
import net.softsociety.exam.domain.WriteBoardForm;
import net.softsociety.exam.service.BoardService;
import net.softsociety.exam.service.BoardSeviceImpl;

/**
 * 상품게시판 관련 콘트롤러
 */
@Slf4j
@RequiredArgsConstructor
@RequestMapping("board")
@Controller
public class BoardController {
	
	private final BoardService boardService;
	private final BoardSeviceImpl boardSeviceImpl;
	private final BoardDAO boardDao;
	
	 @GetMapping(value = "/write")
	 public String writeForm(Model model) {
		 model.addAttribute("writeBoardForm", new WriteBoardForm());
		 return "board/writeForm";
	 }
	 @PostMapping(value = "/write")
	 public String write(@Validated @ModelAttribute("writeBoardForm") WriteBoardForm writeBoardForm, BindingResult bindingResult, @SessionAttribute("loginMember")Member loginMember) {
		 
		 if(bindingResult.hasErrors()) {
			 return "board/writeForm";
		 }
		 Board board = writeBoardForm.toBoard();
		 board.setMember_id(loginMember.getId());
		 boardDao.saveBoard(board);
		 return "redirect:/board/list";
	 }
	@GetMapping(value = "/list")
		public String list(Model model) {
			List<Board> boards = boardDao.findAllBoards();
			model.addAttribute("boards", boards);
			return "board/list";
		}
	
	@GetMapping(value = "read/{id}")
	public String read(@PathVariable long id, Model model) {
		model.addAttribute("board", boardDao.readBoard(id));
		return "board/read";
	}
	
	@GetMapping(value = "remove/{id}")
	public String remove(@PathVariable long id, @SessionAttribute("loginMember")Member loginMember) {
		Board findBoard = boardDao.findBoard(id);
		
		if(!loginMember.getId().equals(findBoard.getMember_id())) {
			 log.info("작성자와 로그인한 사용자가 다름!!");
			return "redirect:/board/list";
		}
		boardDao.removeBoard(id);
		 return "redirect:/board/list";
	}
	 
}
