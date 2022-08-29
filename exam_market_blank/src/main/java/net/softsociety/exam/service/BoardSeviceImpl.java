package net.softsociety.exam.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import net.softsociety.exam.dao.BoardDAO;
import net.softsociety.exam.domain.Board;

@RequiredArgsConstructor
@Transactional
@Service
public class BoardSeviceImpl implements BoardService {

	private final BoardDAO boardDao;
	
	@Override
	public void saveBoard(Board board) {
		boardDao.saveBoard(board);
	}

	@Override
	public List<Board> findAllBoards() {
		List<Board> boards = boardDao.findAllBoards();
		if(boards == null || boards.size() == 0) {
			return null;
		}
		return boards;
	}

	@Override
	public Board findBoard(long id) {
		Board findBoard = boardDao.finBoardById(id);
		return findBoard;
	}

	@Override
	public Board readBoard(long id) {
		Board findBoard = boardDao.finBoardById(id);
		return findBoard;
	}

	@Override
	public void updateBoard(Board board) {
		boardDao.updateBoard(board);
	}

	@Override
	public void removeBoard(long id) {
		boardDao.removeBoard(id);
	}

}
