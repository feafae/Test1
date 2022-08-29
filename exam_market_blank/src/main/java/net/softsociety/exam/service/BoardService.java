package net.softsociety.exam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.softsociety.exam.domain.Board;

@Service
public interface BoardService {
// 컨트롤러에 필요한 것을 여기에 작성.
	public void saveBoard(Board board);
	
	public List<Board> findAllBoards();
	
	public Board findBoard(long id);
	
	public Board readBoard(long id);
	
	public void updateBoard(Board board);
	
	public void removeBoard(long id);
}
