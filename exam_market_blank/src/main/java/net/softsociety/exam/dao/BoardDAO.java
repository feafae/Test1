package net.softsociety.exam.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.exam.domain.Board;
import net.softsociety.exam.domain.Reply;

/**
 * ㄴ돗거쇼ㅏㅗ
 */
@Mapper
public interface BoardDAO {

	public int saveBoard(Board board);

	List<Board> findAllBoards();

	Board finBoardById(long id);

	void updateBoard(Board board);

	void removeBoard(long id);

	public Object readBoard(long id);

	public Board findBoard(long id);

}
