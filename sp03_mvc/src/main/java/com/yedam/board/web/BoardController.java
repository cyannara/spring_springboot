package com.yedam.board.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.board.BoardVO;
import com.yedam.board.mapper.BoardMapper;


@Controller
public class BoardController {
	@Autowired BoardMapper boardMapper;	
	
	//전체조회
	@GetMapping("/board")
	public String selectall(Model model) {
		model.addAttribute("list", boardMapper.getList());
		return "board/list";
	}
	
	//등록페이지
	@GetMapping("/board/register")
	public String registerpage() {
		return "board/register";
	}
	
	//등록처리
	@PostMapping("/board/register")
	public String register(BoardVO board) {
		boardMapper.insert(board);
		return "redirect:/board";
	}
	
}
